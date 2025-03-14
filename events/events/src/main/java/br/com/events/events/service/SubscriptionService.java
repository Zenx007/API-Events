package br.com.events.events.service;

import br.com.events.events.dto.SubscriptionRankingItem;
import br.com.events.events.exception.SubscriptionConflictException;
import br.com.events.events.dto.SubscriptionResponse;
import br.com.events.events.exception.EventNotFoundException;
import br.com.events.events.exception.UserIndicadorNotFoundException;
import br.com.events.events.model.Event;
import br.com.events.events.model.Subscription;
import br.com.events.events.model.User;
import br.com.events.events.repo.EventRepo;
import br.com.events.events.repo.SubscriptionRepo;
import br.com.events.events.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    private EventRepo evtRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SubscriptionRepo subRepo;

    public SubscriptionResponse createNewSubscription(String eventName, User user, Integer userId) {
        Event evt = evtRepo.findByPrettyName(eventName);
        if (evt == null) {
            throw new EventNotFoundException("Evento " + eventName + " não existe");
        }
        User userRec = userRepo.findByEmail(user.getEmail());
        if (userRec == null) {
            userRec = userRepo.save(user);
        }

        User indicador = null;
        if (userId != null) {
            indicador = userRepo.findById(userId).orElse(null);
            if (indicador == null) {
                throw new UserIndicadorNotFoundException("Usuario " + userId + " indicador não existe");
            }
        }
        Subscription subs = new Subscription();
        subs.setEvent(evt);
        subs.setSubscriber(userRec);
        subs.setIndication(indicador);

        Subscription tmpSub = subRepo.findByEventAndSubscriber(evt, userRec);
        if (tmpSub != null) {
            throw new SubscriptionConflictException("Já existe inscrição para o usuário " + userRec.getName() + " no evento " + evt.getTitle());

        }

        Subscription res = subRepo.save(subs);

        return new SubscriptionResponse(res.getSubscriptionNumber(),"http://codecraft.com/subscription/" + res.getEvent().getPrettyName() +"/" + res.getSubscriber().getId());
    }
    public List<SubscriptionRankingItem> getCompleteRanking(String prettyName) {
        Event evt = evtRepo.findByPrettyName(prettyName);
        if (evt == null) {
            throw new EventNotFoundException("Ranking do evento " + prettyName + " não existe" );
        }
        return subRepo.generateRanking(evt.getEventId());

    }
}

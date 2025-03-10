package br.com.events.events.service;

import br.com.events.events.dto.SubscriptionConflictException;
import br.com.events.events.exception.EventNotFoundException;
import br.com.events.events.model.Event;
import br.com.events.events.model.Subscription;
import br.com.events.events.model.User;
import br.com.events.events.repo.EventRepo;
import br.com.events.events.repo.SubscriptionRepo;
import br.com.events.events.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    @Autowired
    private EventRepo evtRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SubscriptionRepo subRepo;

    public Subscription createNewSubscription(String eventName, User user) {
        Event evt = evtRepo.findByPrettyName(eventName);
        if (evt == null) {
            throw new EventNotFoundException("Evento " + eventName + " não existe");
        }
        User userRec = userRepo.findByEmail(user.getEmail());
        if (userRec == null) {
            userRec = userRepo.save(user);
        }
        user= userRepo.save(user);

        Subscription subs = new Subscription();
        subs.setEvent(evt);
        subs.setSubscriber(userRec);

        Subscription tmpSub = subRepo.findByEventAndSubscriber(evt, userRec);
        if (tmpSub != null) {
            throw new SubscriptionConflictException("Já existe inscrição para o usuário " + userRec.getName());

        }

        Subscription res = subRepo.save(subs);
        return res;
    }
}

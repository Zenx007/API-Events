package br.com.events.events.service;

import br.com.events.events.model.Subscription;
import br.com.events.events.model.User;
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

        subs.setEvent(evt);
        subs.setSubscriber(user);

        Subscription res = subRepo.save(subs);
    }
}

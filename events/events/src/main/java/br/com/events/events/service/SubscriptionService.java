package br.com.events.events.service;

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
        Subscription subs = new Subscription();
        return subs;
    }
}

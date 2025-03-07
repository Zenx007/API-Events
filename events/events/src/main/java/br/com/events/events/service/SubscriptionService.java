package br.com.events.events.service;

import br.com.events.events.model.Subscription;
import br.com.events.events.model.User;
import br.com.events.events.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    @Autowired
    private EventRepo evtRepo;

    public Subscription createNewSubscription(String eventName, User user) {
        Subscription subs = new Subscription();
        return subs;
    }
}

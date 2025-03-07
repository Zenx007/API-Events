package br.com.events.events.service;

import br.com.events.events.model.Subscription;
import br.com.events.events.model.User;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    public Subscription createNewSubscription(String eventName, User user) {
        Subscription subs = new Subscription();
        return subs;
    }
}

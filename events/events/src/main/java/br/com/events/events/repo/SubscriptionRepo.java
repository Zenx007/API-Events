package br.com.events.events.repo;

import br.com.events.events.model.Event;
import br.com.events.events.model.Subscription;

import br.com.events.events.model.User;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepo extends CrudRepository<Subscription, Integer> {
    public Subscription findByEventAndSubscriber(Event evt, User user);
}

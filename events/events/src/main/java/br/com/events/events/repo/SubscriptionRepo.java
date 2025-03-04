package br.com.events.events.repo;

import br.com.events.events.model.Subscription;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepo extends CrudRepository<Subscription, Integer> {
}

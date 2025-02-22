package br.com.events.events.repo;

import br.com.events.events.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepo extends CrudRepository<Event,Integer> {
    public Event findByPrettyName(String prettyName);
}


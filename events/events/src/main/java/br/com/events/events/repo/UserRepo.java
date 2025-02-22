package br.com.events.events.repo;

import org.springframework.data.repository.CrudRepository;
import br.com.events.events.model.User;

public interface UserRepo extends CrudRepository<User, Integer>{
    public User findByEmail(String email);



}

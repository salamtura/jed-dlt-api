package com.jedc.apps.repositories;


import com.jedc.apps.entities.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by BRAINERGY SOLUTIONS on 12/27/2017.
 */
public interface UserRepository extends CrudRepository<Users, Integer> {

    Users findByUsername(String username);

}

package com.jedc.apps.services;


import com.jedc.apps.entities.Users;
import com.jedc.apps.models.UserModel;

import javax.persistence.EntityExistsException;
import java.util.List;


/**
 * Created by BRAINERGY SOLUTIONS on 12/27/2017.
 */
public interface UserService {

    Users findByUsername(String username);

    List<Users> findAllUsers();

    Users save(Users user);

    Users findOne(Integer userId);

    void delete(Users user);

    Users createNewUser(UserModel user) throws EntityExistsException;

    void changePassword(String password, Integer userId);
}

package com.jedc.apps.services.implementation;


import com.jedc.apps.entities.Users;
import com.jedc.apps.models.UserModel;
import com.jedc.apps.repositories.UserRepository;
import com.jedc.apps.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;

/**
 * Created by BRAINERGY SOLUTIONS on 12/27/2017.
 */
@Service
public class UserServiceImplementation implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<Users> findAllUsers() {
        return (List<Users>)userRepository.findAll();
    }

    @Override
    public Users save(Users user){
        return userRepository.save(user);
    }

    @Override
    public Users findOne(Integer userId){
        return userRepository.findOne(userId);
    }

    @Override
    public void delete(Users user){
        userRepository.delete(user);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Users createNewUser(UserModel accountDto) throws EntityExistsException {
        Users user1 = new Users();
        user1.setUsername(accountDto.getUsername());
        long time = System.currentTimeMillis();
        java.sql.Timestamp date = new java.sql.Timestamp(time);
        user1.setPassword(passwordEncoder.encode(accountDto.getPassword()));

        Users savedUser = userRepository.save(user1);

        return savedUser;
    }

    @Override
    public void changePassword(String password, Integer userId){
        //userRoleRepository.changeUserPassword(password, userId);
    }
}

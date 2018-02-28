package com.jedc.apps.controllers;


import com.jedc.apps.entities.Users;
import com.jedc.apps.models.UserModel;
import com.jedc.apps.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by BRAINERGY SOLUTIONS on 1/4/2018.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Get all users
    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public ResponseEntity<List<Users>> getUsers(){
        List<Users> allUsers =  userService.findAllUsers();

        return ResponseEntity.ok().body(allUsers);
    }


    //Save a user
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public ResponseEntity<Users> createUser(@Valid @RequestBody UserModel userModel)
    {
        Users user = userService.createNewUser(userModel);

        return ResponseEntity.ok().body(user);
    }

    //Get a user details
    @GetMapping("/me")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATOR', 'PARTNER', 'SUPERVISOR','FINANCE', 'RECORDS', 'CUSTOMERSERVICE')")
    public ResponseEntity<OAuth2Authentication> user(OAuth2Authentication authentication) {
        if(authentication == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(authentication);
    }


    //Get a user details
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATOR', 'SUPERVISOR','FINANCE', 'RECORDS', 'CUSTOMERSERVICE')")
    public ResponseEntity<Users> getUserById(@PathVariable(value = "id") Integer userId) {
        Users user = userService.findOne(userId);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    //Update a User..
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATOR', 'SUPERVISOR')")
    public ResponseEntity<Users> updateUser(@PathVariable(value = "id") Integer userId,
                                            @Valid @RequestBody Users userDetails) {
        Users user = userService.findOne(userId);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        long time = System.currentTimeMillis();
        java.sql.Timestamp date = new java.sql.Timestamp(time);
        user.setUsername(userDetails.getUsername());
        user.setUserRolesById(userDetails.getUserRolesById());

        Users updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public ResponseEntity deleteUser(@PathVariable(value = "id") Integer userId) {
        Users user = userService.findOne(userId);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }

        userService.delete(user);
        return ResponseEntity.ok().build();
    }

    //Change User Password
    @PutMapping("/change_password/{id}/password")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATOR', 'PARTNER', 'RECORDS', 'CUSTOMER SERVICE', 'FINNACE', 'SUPERVISOR')")
    public ResponseEntity changeUserPassword(@PathVariable("user_id") Integer user_id, @RequestBody String password)
    {
        userService.changePassword(password, user_id);

        return ResponseEntity.ok().build();
    }
}

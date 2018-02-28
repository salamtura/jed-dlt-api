package com.jedc.apps.services.implementation;

import com.jedc.apps.entities.Users;
import com.jedc.apps.models.AppUser;
import com.jedc.apps.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BRAINERGY SOLUTIONS on 12/27/2017.
 */

@Component
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user = userService.findByUsername(s);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getUserRolesById().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRolesByRoleId().getName()));
        });

        UserDetails userDetails = new AppUser(user, authorities);


        return userDetails;
    }
}



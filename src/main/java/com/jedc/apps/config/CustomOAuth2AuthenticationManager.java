package com.jedc.apps.config;


import com.jedc.apps.PowercoinApplication;
import com.jedc.apps.entities.Users;
import com.jedc.apps.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BRAINERGY SOLUTIONS on 04/01/2018.
 */
public class CustomOAuth2AuthenticationManager extends OAuth2AuthenticationManager {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserService userService = PowercoinApplication.getContext().getBean(UserService.class);
//        PermissionDao permissionDao= Application.getContext().getBean(PermissionDao.class);
        OAuth2Authentication auth = (OAuth2Authentication) super.authenticate(authentication);
        if (!auth.isClientOnly()) {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) auth.getUserAuthentication();
            Users user = userService.findByUsername(usernamePasswordAuthenticationToken.getName());
            if (user != null) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                user.getUserRolesById().forEach(role -> {
                    authorities.add(new SimpleGrantedAuthority(role.getRolesByRoleId().getName()));
                });
//                GrantedAuthority authority = new SimpleGrantedAuthority(userService.getUserRole(user.getId()));
                UsernamePasswordAuthenticationToken userAuthentication = new UsernamePasswordAuthenticationToken(user, null, authorities);
                OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(auth.getOAuth2Request(), userAuthentication);
                oAuth2Authentication.setDetails(auth.getDetails());
                oAuth2Authentication.setAuthenticated(true);
                return oAuth2Authentication;
            }

        }
        return auth;
    }
}
package com.springboot.jwt.config.jwt;

import com.springboot.jwt.model.User;
import com.springboot.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userFromDB = userService.getUserByUsername(username);
        if (userFromDB == null) {
            throw new UsernameNotFoundException("User not found from db.");
        }
        return new UserJwtDetails(userFromDB);
    }
}

package com.springboot.jwt.service;

import com.springboot.jwt.model.User;

public interface UserService {
    public User getUserByUsernameAndPassword(String username);
}

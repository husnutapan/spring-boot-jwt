package com.springboot.jwt.service;

import com.springboot.jwt.model.User;

public interface UserService {
    User getUserByUsername(String username);
}

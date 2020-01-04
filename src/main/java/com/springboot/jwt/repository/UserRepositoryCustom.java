package com.springboot.jwt.repository;

import com.springboot.jwt.model.User;

import java.util.Optional;

public interface UserRepositoryCustom {
    Optional<User> findUserByUsername(String username);
}

package com.example.springboottry.service;

import com.example.springboottry.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void save(User user);

    List<User> findAll();

    Optional<User> findById(int id);

    void deleteById(int id);
}

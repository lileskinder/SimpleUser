package com.example.simpleuser.service;

import com.example.simpleuser.model.User;

import java.util.List;

public interface SimpleUserService {
    User addUser(User user);
    void deleteUser(String userName);
    User updateUser(User updatedUser);
    User findUser(String userName);
    List<User> findAllUsers();
}

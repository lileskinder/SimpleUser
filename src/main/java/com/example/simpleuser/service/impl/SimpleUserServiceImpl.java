package com.example.simpleuser.service.impl;

import com.example.simpleuser.DAO.SimpleUserRepository;
import com.example.simpleuser.model.User;
import com.example.simpleuser.service.SimpleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleUserServiceImpl implements SimpleUserService {

    private final SimpleUserRepository repository;

    @Autowired
    public SimpleUserServiceImpl(SimpleUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User addUser(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteUser(String userName) {
        repository.deleteUserByUserName(userName);
    }

    @Override
    public User updateUser(User updatedUser) {
        return repository.save(updatedUser);
    }

    @Override
    public User findUser(String userName) {
        return repository.findById(userName).orElse(new User());
    }

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }
}

package com.hrproj.service;

import com.hrproj.entity.User;

import java.util.List;

public interface UserService {
        User addUser(User user);
        void deleteById(long id);
        User getByLogin(String login);
        User editUser(User user);
        List<User> getAll();
}

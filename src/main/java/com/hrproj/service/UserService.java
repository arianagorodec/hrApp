package com.hrproj.service;

import com.hrproj.entity.User;


public interface UserService {
        User addUser(User user);

        void deleteById(long id);

        User getById_user(long id);

        User getByUsername(String username);

        User editUser(User user);

        //List<User> getAll();
}

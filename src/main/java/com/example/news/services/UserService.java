package com.example.news.services;

import com.example.news.dob.User;

import java.util.List;

public interface UserService {

    User findUserById(Long userId);

    void deleteUser(Long userId);

    List<User> findAll();

    List<User> userList(Long idMin);

    User save(User user);
}

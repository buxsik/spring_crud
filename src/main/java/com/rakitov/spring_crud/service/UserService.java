package com.rakitov.spring_crud.service;

import com.rakitov.spring_crud.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    void createUser(User user, String[] roles);
    User findUserById(Long id);
    void updateUser(User user, String[] roles);
    void removeUser(Long id);
}

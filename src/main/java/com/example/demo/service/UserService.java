package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
     void createUser(User user);
     void deleteById(int id);
     void updateUser(User user, int id);
     List<User> displayAll();
     User searchById(Integer Id);
     List<User> searchByName(String name);
     void deleteAll();
     List<User> searchByDescription(String description);
}

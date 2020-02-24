package com.example.demo;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
     void createUser(User user);
     void deleteById(Integer id);
     void updateDescription(User user);
     List<User> displayAll();
     User searchById(Integer Id);
     List<User> searchByName(String name);
     void deleteAll();
}

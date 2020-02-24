package com.example.demo;

import java.util.List;

public interface UserTemplate {
     void createUser(String name, String description);
     void deleteById(Integer id);
     void updateDescription(Integer id, String description);
     List<User> displayAll();
     User searchById(Integer Id);
     List<User> searchByName(String name);
     void deleteAll();
}

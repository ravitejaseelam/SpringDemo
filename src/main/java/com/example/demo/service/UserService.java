package com.example.demo.service;

import com.example.demo.UserControllerAdvice.UserInvalidDataException;
import com.example.demo.UserControllerAdvice.UserNotFoundException;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user) throws UserInvalidDataException;

    void deleteById(int id) throws UserNotFoundException;

    void updateUser(User user, int id) throws UserNotFoundException;

    List<User> displayAll() throws UserNotFoundException;

    User searchById(Integer Id) throws UserNotFoundException;

    List<User> searchByName(String name) throws UserNotFoundException;

    void deleteAll();

    List<User> searchByDescription(String description) throws UserNotFoundException;
}

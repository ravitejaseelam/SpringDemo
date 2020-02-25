package com.example.demo.controller;

import com.example.demo.UserControllerAdvice.UserExceptionHandler;
import com.example.demo.UserControllerAdvice.UserInvalidDataException;
import com.example.demo.UserControllerAdvice.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.UserServiceImpl;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController implements UserService {

    @Autowired
    private UserServiceImpl userServiceImpl;
    private UserExceptionHandler exceptionHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) throws UserInvalidDataException {
        userServiceImpl.createUser(user);
    }

    @GetMapping(params = "getAllByName")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<User> searchByName(@RequestParam(value = "getAllByName") String name) throws UserNotFoundException {
        return userServiceImpl.searchByName(name);
    }

    @GetMapping(params = "getById")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User searchById(@RequestParam(value = "getById") Integer Id) throws UserNotFoundException {
        return userServiceImpl.searchById(Id);
    }

    @GetMapping(params = "getAllByDescription")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<User> searchByDescription(@RequestParam(value = "getAllByDescription") String description) throws UserNotFoundException {
        return userServiceImpl.searchByDescription(description);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<User> displayAll() throws UserNotFoundException {
        return userServiceImpl.displayAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUser(@RequestBody User user, @PathVariable("id") int id) throws UserNotFoundException {
        userServiceImpl.updateUser(user, id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteById(@PathVariable("id") int id) throws UserNotFoundException {
        userServiceImpl.deleteById(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        userServiceImpl.deleteAll();
    }

}

package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.UserServiceImpl;
import com.example.demo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController implements UserService {
@Autowired private UserServiceImpl userServiceImpl;

    @PostMapping("/{name}/{description}")
    public void createUser(@RequestBody User user ) {
        userServiceImpl.createUser(user);
    }

    @GetMapping(params = "getAllByName")
    public List<User> searchByName(@RequestParam(value="getAllByName") String name)
    { return userServiceImpl.searchByName(name); }

    @GetMapping(params = "getById")
    public User searchById(@RequestParam(value="getById") Integer Id){
        return userServiceImpl.searchById(Id);
    }

    @GetMapping
    public List<User> displayAll(){ return userServiceImpl.displayAll(); }

    //todo take payload @Requestbody
    @PutMapping("/{id}/{description}")
    public void updateDescription(@RequestBody User user){
        userServiceImpl.updateDescription(user);
    }

    @DeleteMapping(params ="id")
    public void deleteById(@RequestParam(value="id") Integer id){
        userServiceImpl.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll(){
     userServiceImpl.deleteAll();
    }
}

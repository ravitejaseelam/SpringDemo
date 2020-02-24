package com.example.demo.web;

import com.example.demo.User;
import com.example.demo.UserService;
import com.example.demo.UserTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserController implements UserTemplate {
@Autowired private UserService userService;

    @PostMapping("/{name}/{description}")
    public void createUser(@PathVariable String name, @PathVariable String description) {
        userService.createUser(name, description);
    }

    @GetMapping("/SearchByName/{name}")
    public List<User> searchByName(@PathVariable String name){ return userService.searchByName(name); }

    @GetMapping("/{Id}")
    public User searchById(@PathVariable Integer Id){
        return userService.searchById(Id);
    }

    @GetMapping
    public List<User> displayAll(){ return userService.displayAll(); }

    @PutMapping("/{id}/{description}")
    public void updateDescription(@PathVariable Integer id,@PathVariable String description){
        userService.updateDescription(id,description);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        userService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll(){
     userService.deleteAll();
    }
}

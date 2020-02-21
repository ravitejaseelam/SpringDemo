package com.example.demo.web;

import com.example.demo.User;
import com.example.demo.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserController {
@Autowired private UserManager taskManager;

    @PostMapping("/{name}/{description}")
    public String addUser(@PathVariable String name, @PathVariable String description) {
        taskManager.add(name, description);
        return name+" is added";
    }
    @GetMapping("/SearchByName/{name}")
    public List<User> searchByName(@PathVariable String name){
        return taskManager.searchByName(name);
    }
    @GetMapping("/SearchById/{Id}")
    public List<User> searchById(@PathVariable Integer Id){
        return taskManager.searchById(Id);
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Integer id){
        User obj=taskManager.deleteById(id);
        return obj.name+" is Deleted";
    }
    @PutMapping("/UpdateDescription/{id}/{description}")
    public String updateDes(@PathVariable Integer id,@PathVariable String description){
        User obj=taskManager.updateDes(id,description);
        return obj.name+" is Updated";
    }
    @GetMapping
    public List<User> displayAll(){
        return taskManager.displayAll();
    }
    @DeleteMapping
    public String deleteAll(){
     taskManager.deleteAll();
     return "Data is Delete";
    }
}

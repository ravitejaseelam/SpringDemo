package com.example.demo.web;

import com.example.demo.User;
import com.example.demo.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
@Autowired private UserManager taskManager;

    @RequestMapping("/AddMember/{name}/{description}")
    public String addUser(@PathVariable String name, @PathVariable String description) {
        taskManager.add(name, description);
        return name+" is added";
    }
    @RequestMapping("/SearchByName/{name}")
    public List<User> searchByName(@PathVariable String name){
        return taskManager.searchByName(name);
    }
    @RequestMapping("/SearchById/{Id}")
    public List<User> searchById(@PathVariable Integer Id){
        return taskManager.searchById(Id);
    }
    @RequestMapping("/DeleteById/{id}")
    public String deleteById(@PathVariable Integer id){
        User obj=taskManager.deleteById(id);
        return obj.name+" is Deleted";
    }
    @RequestMapping("/UpdateDescription/{id}/{description}")
    public String updateDes(@PathVariable Integer id,@PathVariable String description){
        User obj=taskManager.updateDes(id,description);
        return obj.name+" is Updated";
    }
    @RequestMapping("/DisplayAll")
    public List<User> displayAll(){
        return taskManager.displayAll();
    }
    @RequestMapping("/DeleteAll")
    public String deleteAll(){
     taskManager.deleteAll();
     return "Data is Delete";
    }
}

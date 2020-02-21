package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserManager {
    @Autowired
    private UserMemoryRepository repo;

    public void add(String name,String description){
         repo.add(name,description);

    }
    public User deleteById(Integer id){
        return repo.deleteById(id);
    }
    public User updateDes(Integer id, String description){
        return repo.updateDes(id,description);
    }
    public List<User> displayAll(){
        return repo.displayAll();
    }
    public List<User> searchById(Integer Id){
        return repo.searchById(Id);
    }
    public List<User> searchByName(String name){
        return repo.searchByName(name);
    }
    public void deleteAll(){
        repo.deleteAll();
    }
}

package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMemoryRepository {
    List<User> taskList =new ArrayList<>();
    int id=0;

    public void add(String name,String description){
        taskList.add(new User(name,description,id));
        id++;
    }
    public User deleteById(Integer id){

        for (User obj : taskList) {
          if(obj.id.equals(id)) {
              taskList.remove(obj);
              return obj;
          }
        }
        return null;
    }
    public User updateDes(Integer id, String description){

        for (User obj : taskList) {
            if(obj.id.equals(id)) {
                obj.description=description;
                return obj;
            }
        }
        return null;
    }
    public List<User> displayAll(){

        List<User> addedPersons = new ArrayList<User>();
        for (User obj : taskList) {
                addedPersons.add(obj);
        }
        return addedPersons;
    }
    public List<User> searchByName(String name){

        List<User> searchResults = new ArrayList<User>();
        for (User obj : taskList) {
            if(obj.name.equals(name))
            searchResults.add(obj);
        }
        return searchResults;
    }
    public List<User> searchById(Integer Id){

        List<User> searchResults = new ArrayList<User>();
        for (User obj : taskList) {
            if(obj.id.equals(Id))
                searchResults.add(obj);
        }
        return searchResults;
    }
    public void deleteAll(){
         taskList.clear();
         id=0;
        }

}

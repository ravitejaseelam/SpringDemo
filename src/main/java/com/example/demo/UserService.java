package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserTemplate {
@Autowired
UserDAO dao;
    @Override
    public void createUser(String name, String description) {
        User obj=new User();
        obj.setName(name);
        obj.setDescription(description);
       dao.save(obj);
    }

    @Override
    public void deleteById(Integer id) {
            dao.deleteById(id);
    }

    @Override
    public void updateDescription(Integer id, String description) {
        User obj= dao.findById(id).get();
        obj.setDescription(description);
        dao.save(obj);
    }

    @Override
    public List<User> displayAll() {
       return dao.findAll();
    }

    @Override
    public User searchById(Integer Id) {
        return dao.findById(Id).get();
    }

    @Override
    public List<User> searchByName(String name) {
        return dao.findAllByName(name);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }
}
package com.example.demo;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
@Autowired
UserDAO dao;
    @Override
    public void createUser(User obj) {
       dao.save(obj);
    }

    @Override
    public void deleteById(Integer id) {
            dao.deleteById(id);
    }

    @Override
    public void updateDescription(User obj) {
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
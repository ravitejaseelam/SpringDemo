package com.example.demo.service;

import com.example.demo.UserControllerAdvice.UserExceptionHandler;
import com.example.demo.dao.UserDAO;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO dao;
    UserExceptionHandler exceptionHandler;

    @Override
    public void createUser(User obj) {
        if (obj.getName() == null || obj.getDescription() == null)
            throw new NullPointerException("All parameters are mandatory");
        else
            dao.save(obj);
    }

    @Override
    public void deleteById(int id) {
        if (!dao.findById(id).isPresent())
            throw new NoSuchElementException("Could not find user with id:"+id);
        else
            dao.deleteById(id);
    }

    @Override
    public void updateUser(User obj, int id) {

        if (!dao.findById(id).isPresent())
            throw new NoSuchElementException("Could not find user with id:"+id);
        else {
            obj.setId(id);
            dao.save(obj);
        }
    }

    @Override
    public List<User> displayAll() {

        if (dao.findAll().isEmpty())
            throw new NoSuchElementException("no data to display");
        else
            return dao.findAll();
    }

    @Override
    public User searchById(Integer id) {

        if (!dao.findById(id).isPresent())
            throw new NoSuchElementException("Could not find user with id:"+id);
        else
            return dao.findById(id).get();
    }

    @Override
    public List<User> searchByName(String name) {
        if (dao.findAllByName(name).isEmpty())
            throw new NoSuchElementException("Could not find user with name:"+name);
        else
            return dao.findAllByName(name);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }

    @Override
    public List<User> searchByDescription(String description) {
        if (dao.findAllByDescription(description).isEmpty())
            throw new NoSuchElementException("Could not find user with description:"+description);
        else
            return dao.findAllByDescription(description);
    }
}
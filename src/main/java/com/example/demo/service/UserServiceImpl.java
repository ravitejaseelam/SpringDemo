package com.example.demo.service;

import com.example.demo.exception.UserInvalidDataException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.dao.UserDAO;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserDAO dao;


    @Override
    public void createUser(User obj) throws UserInvalidDataException {
        if (obj.getName() == null || obj.getDescription() == null)
            throw new UserInvalidDataException("All parameters are mandatory");
        else
            dao.save(obj);
    }

    @Override
    public void deleteById(int id) throws UserNotFoundException {
        if (!dao.findById(id).isPresent())
            throw new UserNotFoundException("Could not find user with id:" + id);
        else
            dao.deleteById(id);
    }

    @Override
    public void updateUser(User obj, int id) throws UserNotFoundException {

        if (!dao.findById(id).isPresent())
            throw new UserNotFoundException("Could not find user with id:" + id);
        else {
            obj.setId(id);
            dao.save(obj);
        }
    }

    @Override
    public List<User> displayAll() throws UserNotFoundException {

        if (dao.findAll().isEmpty())
            throw new UserNotFoundException("no data to display");
        else
            return dao.findAll();
    }

    @Override
    public User searchById(Integer id) throws UserNotFoundException {


        if (!dao.findById(id).isPresent())
            throw new UserNotFoundException("Could not find user with id:" + id);
        else
            return dao.findById(id).get();
    }

    @Override
    public List<User> searchByName(String name) throws UserNotFoundException {
        if (dao.findAllByName(name).isEmpty())
            throw new UserNotFoundException("Could not find user with name:" + name);
        else
            return dao.findAllByName(name);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }

    @Override
    public List<User> searchByDescription(String description) throws UserNotFoundException {
        if (dao.findAllByDescription(description).isEmpty())
            throw new UserNotFoundException("Could not find user with description:" + description);
        else
            return dao.findAllByDescription(description);
    }
}
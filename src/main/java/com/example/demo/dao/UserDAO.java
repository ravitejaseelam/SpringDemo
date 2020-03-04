package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
    List<User> findAllByName(String name);

    List<User> findAllByDescription(String description);
}

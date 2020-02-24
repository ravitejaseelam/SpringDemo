package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
    @Column(name="name")
     String name;
    @Column(name="description")
        String description;
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name ="id")
     Integer id;

    public User(){}
    public User(String name, String description, Integer id) {
        this.name = name;
        this.description=description;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
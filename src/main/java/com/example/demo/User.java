package com.example.demo;

public class User {
    public String name,description;
    public Integer id;


    public User() {
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

    public User(String name, String description, Integer id) {
        this.name = name;
        this.description=description;
        this.id=id;
    }


}
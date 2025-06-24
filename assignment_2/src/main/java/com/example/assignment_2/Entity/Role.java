package com.example.assignment_2.Entity;

public class Role {
    public int id;
    public String name;

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Role()
    {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

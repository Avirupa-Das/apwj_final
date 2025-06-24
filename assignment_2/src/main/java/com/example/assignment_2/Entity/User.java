package com.example.assignment_2.Entity;

public class User {
    public int id;
    public String userName;
    public String password;
    public int roleId;
    public String email;

    public User(int id, String userName, String password, int roleId, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.roleId = roleId;
        this.email = email;
    }
    public User()
    {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return roleId;
    }

    public void setRole(int roleId) {
        this.roleId = roleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

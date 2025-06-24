package com.example.assignment_2.Entity;

import java.util.List;

public class Cart {
    public int id;
    public int userId;
    public List<CartItem> items;

    public Cart(int id, int userId, List<CartItem> items) {
        this.id = id;
        this.userId = userId;
        this.items = items;
    }
    public Cart()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
}

package com.example.assignment_2.Entity;

public class WishLists {
    public int id;
    public int userId;
    public int productId;

    public WishLists(int id, int userId, int productId) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
    }
    public WishLists()
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

    public int getProducts() {
        return productId;
    }

    public void setProducts(int productId) {
        this.productId = productId;
    }
}

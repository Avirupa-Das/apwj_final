package com.example.assignment_2.Entity;

import java.time.LocalDateTime;

public class Order {
    public int id;
    public LocalDateTime orderDate;
    public int userId;
    public double totalAmount;

    public Order(int id, LocalDateTime orderDate, int userId, double totalAmount) {
        this.id = id;
        this.orderDate = orderDate;
        this.userId = userId;
        this.totalAmount = totalAmount;
    }
    public Order()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}

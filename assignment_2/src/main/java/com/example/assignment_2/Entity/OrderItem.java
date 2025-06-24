package com.example.assignment_2.Entity;

public class OrderItem {
    public int id;
    public int orderId;
    public int productId;
    public int productQuantity;
    public double price;
    private double totalPrice;

    public OrderItem( int orderId, int productId, int productQuantity, double price, double totalPrice) {
        this.orderId = orderId;
        this.productId = productId;
        this.productQuantity = productQuantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }
    public OrderItem()
    {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

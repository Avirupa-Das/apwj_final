package com.example.assignment_2.Entity;

import java.time.LocalDateTime;

public class Invoice {
    public int id;
    public int orderId;
    public LocalDateTime invoDate;
    public double totalAmount;
    public double discount;
    public double finalAmount;

    public Invoice(int id, int orderId, LocalDateTime invoDate, double totalAmount, double discount, double finalAmount) {
        this.id = id;
        this.orderId = orderId;
        this.invoDate = invoDate;
        this.totalAmount = totalAmount;
        this.discount = discount;
        this.finalAmount = finalAmount;
    }
    public Invoice()
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

    public LocalDateTime getInvoDate() {
        return invoDate;
    }

    public void setInvoDate(LocalDateTime invoDate) {
        this.invoDate = invoDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }
}

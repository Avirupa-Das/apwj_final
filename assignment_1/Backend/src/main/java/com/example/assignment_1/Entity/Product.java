package com.example.assignment_1.Entity;

import java.time.LocalDate;

public class Product {
    public int ID;
    public String Name;
    public double Price;
    public int Quantity;
    public LocalDate ExpiryDate;
    public PdtCategory productCategory;
    public boolean Availablity;

    public Product(int ID, String name, double price, int quantity, LocalDate expiryDate, PdtCategory productCategory) {
        this.ID = ID;
        this.Name = name;
        this.Price = price;
        this.Quantity = quantity;
        this.ExpiryDate = expiryDate;
        this.productCategory = productCategory;
        if (Quantity<0)
        {
            this.Availablity=false;
        }
        else
        {
            this.Availablity=true;
        }
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public LocalDate getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        ExpiryDate = expiryDate;
    }

    public PdtCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(PdtCategory productCategory) {
        this.productCategory = productCategory;
    }
}

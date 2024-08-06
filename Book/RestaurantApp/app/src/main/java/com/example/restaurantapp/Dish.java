package com.example.restaurantapp;

import androidx.annotation.NonNull;

public class Dish {
    String title;
    String description;
    double price;
    public Dish(String title, String description, double price){
        this.title=title;
        this.description =description;
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @NonNull
    @Override
    public String toString() {
        return (title+ ": "+ description+"  "+price);
    }
}

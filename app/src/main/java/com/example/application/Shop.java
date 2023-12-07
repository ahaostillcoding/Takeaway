package com.example.application;

public class Shop {
    private int imageID;
    private String name;
    private String price;
    public int getImageID() {
        return imageID;
    }
    public String getName() {
        return name;
    }
    public String getPrice() {
        return price;
    }
    public Shop(int imageID, String name, String price) {
        this.imageID = imageID;
        this.name = name;
        this.price = price;
    }
}

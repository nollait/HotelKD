package com.example.hotelkd;

public class Room {

    private int icon;
    private String name;
    private String price;
    private String description;

    public Room(int icon, String name, String price, String description) {
        this.icon = icon;
        this.name = name;
        this.price = price;
        this.description = description;

    }

    public int getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
    public String getDescription() {return description; }
}
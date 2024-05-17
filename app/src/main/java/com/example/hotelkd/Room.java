package com.example.hotelkd;

public class Room {

    private int icon;
    private String name;
    private String price;

    public Room(int icon, String name, String price) {
        this.icon = icon;
        this.name = name;
        this.price = price;

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
}
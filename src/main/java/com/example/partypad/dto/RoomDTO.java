package com.example.partypad.dto;

public class RoomDTO {
    private int id;
    private String title;
    private String description;
    private int price;

    private String location;

    private int guests;

    private int size;

    private String username ;
//    public RoomDTO(int id, String title, String description, int price) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.price = price;
//    }


    public RoomDTO(int id, String title, String description, int price, String location, int guests, int size ,String username) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.location = location;
        this.guests = guests;
        this.size = size;
        this.username = username ;
    }

    public RoomDTO() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

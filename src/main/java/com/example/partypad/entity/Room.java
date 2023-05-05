package com.example.partypad.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private int price;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "address_id", nullable = false)
//    private Address address;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "username", nullable = false)
//    private User user;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "username")
//    private User user;

    @Column(name="username")
    private String username;


    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "guests", nullable = false)
    private int guests;

    @Column(name = "size", nullable = false)
    private int size;

    public Room() {
    }

    public Room(String title, String description, int price,  String username, String location, int guests, int size) {
        this.title = title;
        this.description = description;
        this.price = price;

        this.username = username;
        this.location = location;
        this.guests = guests;
        this.size = size;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    // toString method
    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", username=" + username +
                '}';
    }
}

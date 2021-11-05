package com.website.entities;

import org.springframework.stereotype.Repository;

@Repository
public class User {
    private int id;
    private String name;
    private String email;
    private Long phoneNumber;
    private String imageUrl;

    // 2 different constructors
    public User() {
    }

    public User(String name, String email, Long phoneNumber, String imageUrl) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

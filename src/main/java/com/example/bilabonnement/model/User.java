package com.example.bilabonnement.model;

public class User {

    private String username;
    private String password;
    private int userId;
    private String role;

    public User(String username, String password, int userId, String role) {
        this.username = username;
        this.password = password;
        this.userId = userId;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }
}

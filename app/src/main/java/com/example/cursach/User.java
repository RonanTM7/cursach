package com.example.cursach;

/**
 * This class represents a single user.
 * It's a simple Plain Old Java Object (POJO)
 * that Gson will use to parse the JSON response from the API.
 */
public class User {
    private int id;
    private String name;
    private String email;

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

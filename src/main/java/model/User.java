package model;

import java.io.Serializable;

public class User implements Serializable {

    public enum Role{admin, user}

    // Unique identifier for the user
    private int userId;

    // User's full name
    private String name;

    // User's email address (used for login)
    private String email;

    // User's password (should be hashed in production)
    private String password;

    // User's role (admin or regular user)
    private Role role;

    // User's profile picture stored as byte array
    private byte[] image;

    public User() {
    }

    public User(String name, String email, String password, Role role, byte[] image) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.image = image;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}

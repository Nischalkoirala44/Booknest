package model;

import java.io.Serializable;

public class User implements Serializable {

    public enum Role {admin, user}

    private int userId;
    private String name;
    private String email;
    private String password;
    private Role role;
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
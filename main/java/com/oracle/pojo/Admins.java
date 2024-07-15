package com.oracle.pojo;

public class Admins {
    private Integer admin_id;
    private String username;
    private String password;
    private String name;
    private String avatar;
    private String phone;
    private String email;

    public Admins() {
    }

    @Override
    public String toString() {
        return "Admins{" +
                "admin_id=" + admin_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Admins(Integer admin_id, String username, String password, String name, String avatar, String phone, String email) {
        this.admin_id = admin_id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.avatar = avatar;
        this.phone = phone;
        this.email = email;
    }
}

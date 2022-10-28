package com.revature.model;

import java.util.Objects;

public class UserModel {
    int user_id;

    String username;

    String email;

    String password;

    int role_num;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getRole_num() {
        return role_num;
    }

    public void setRole_num(int role_num) {
        this.role_num = role_num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return user_id == userModel.user_id && role_num == userModel.role_num && username.equals(userModel.username) && email.equals(userModel.email) && password.equals(userModel.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, username, email, password, role_num);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role_num=" + role_num +
                '}';
    }
}

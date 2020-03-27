package com.community.entity;

public class User {
    private String userId;

    private String password;

    private String authority;

    private String openId;

    public User() {
    }

    public User(String userId, String password, String authority, String openId) {
        this.userId = userId;
        this.password = password;
        this.authority = authority;
        this.openId = openId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority == null ? null : authority.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", authority='" + authority + '\'' +
                ", openId='" + openId + '\'' +
                '}';
    }
}
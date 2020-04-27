package com.community.entity;

public class Family extends User {

    private String userName;

    private String phone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    @Override
    public String toString() {
        return "Family{" +
                "userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
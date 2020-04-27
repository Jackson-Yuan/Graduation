package com.community.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Menu {
    private String id;

    private String breakfast;

    private String lunch;

    private String dinner;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast == null ? null : breakfast.trim();
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch == null ? null : lunch.trim();
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner == null ? null : dinner.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
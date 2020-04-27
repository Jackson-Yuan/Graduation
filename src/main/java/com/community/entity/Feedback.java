package com.community.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Feedback {
    private String id;

    private String userId;

    private Integer type;

    private String contact;

    private String pictureUrl;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;

    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", type=" + type +
                ", contact='" + contact + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                '}';
    }
}
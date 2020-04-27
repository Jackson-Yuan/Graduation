package com.community.entity.data;

import java.util.Date;

public class BodyData {
    private String userId;

    private String userName;

    private String deviceId;

    private Double bloodPressure;

    private Double heartRate;

    private Double temperature;

    private Date uploadDate;

    public BodyData() {
    }

    public BodyData(String deviceId, Double bloodPressure, Double heartRate, Double temperature, Date uploadDate) {
        this.deviceId = deviceId;
        this.bloodPressure = bloodPressure;
        this.heartRate = heartRate;
        this.temperature = temperature;
        this.uploadDate = uploadDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public Double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(Double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Double heartRate) {
        this.heartRate = heartRate;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public String toString() {
        return "BodyData{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", bloodPressure=" + bloodPressure +
                ", heartRate=" + heartRate +
                ", temperature=" + temperature +
                ", uploadDate=" + uploadDate +
                '}';
    }
}
package com.community.entity.data;

import java.util.Date;

public class EnvironmentData {
    private String userId;

    private String deviceId;

    private Double indoorTemperature;

    private Double humidity;

    private Double smokeConcentration;

    private Double lightIntensity;

    private Date uploadDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public Double getIndoorTemperature() {
        return indoorTemperature;
    }

    public void setIndoorTemperature(Double indoorTemperature) {
        this.indoorTemperature = indoorTemperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getSmokeConcentration() {
        return smokeConcentration;
    }

    public void setSmokeConcentration(Double smokeConcentration) {
        this.smokeConcentration = smokeConcentration;
    }

    public Double getLightIntensity() {
        return lightIntensity;
    }

    public void setLightIntensity(Double lightIntensity) {
        this.lightIntensity = lightIntensity;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public String toString() {
        return "EnvironmentData{" +
                "userId='" + userId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", indoorTemperature=" + indoorTemperature +
                ", humidity=" + humidity +
                ", smokeConcentration=" + smokeConcentration +
                ", lightIntensity=" + lightIntensity +
                ", uploadDate=" + uploadDate +
                '}';
    }
}
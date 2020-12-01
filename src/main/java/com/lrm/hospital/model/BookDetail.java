package com.lrm.hospital.model;

public class BookDetail {
    private String id;

    private String userId;

    private String scheduleId;

    private Integer scheduleNumber;

    private String status;

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

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId == null ? null : scheduleId.trim();
    }

    public Integer getScheduleNumber() {
        return scheduleNumber;
    }

    public void setScheduleNumber(Integer scheduleNumber) {
        this.scheduleNumber = scheduleNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}
package com.lrm.hospital.model;

import java.util.Date;

public class Schedule {
    private String id;

    private String doctorId;

    private Date scheduleDate;

    private Integer totalQuota;

    private Integer currentQuota;

    private Integer currentNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId == null ? null : doctorId.trim();
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Integer getTotalQuota() {
        return totalQuota;
    }

    public void setTotalQuota(Integer totalQuota) {
        this.totalQuota = totalQuota;
    }

    public Integer getCurrentQuota() {
        return currentQuota;
    }

    public void setCurrentQuota(Integer currentQuota) {
        this.currentQuota = currentQuota;
    }

    public Integer getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(Integer currentNumber) {
        this.currentNumber = currentNumber;
    }
}
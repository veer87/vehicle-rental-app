package com.assignment.navi.model;

import com.assignment.navi.model.Enums.VehicleType;

public class BookingEntry {
    private String vehicleId;
    long startTime;
    long endTime;

    public BookingEntry(String vehicleId, long startTime, long endTime) {
        this.vehicleId = vehicleId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}

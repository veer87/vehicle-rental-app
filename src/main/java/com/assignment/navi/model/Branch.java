package com.assignment.navi.model;

import com.assignment.navi.model.Enums.VehicleType;

import java.util.*;

public class Branch {
    private String id;
    private String name;
    private Set<VehicleType> vehicleTypesList = new HashSet<>();
    private Map<VehicleType, Integer> vehicleCountMap = new HashMap<>();
    private Map<String, Vehicle> vehicleMap = new HashMap<>();

    Booking booking = new Booking();


    public Branch(String name, List<VehicleType> vehicleTypeList) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.vehicleTypesList.addAll(vehicleTypeList);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<VehicleType> getVehicleTypesList() {
        return vehicleTypesList;
    }

    public Map<VehicleType, Integer> getVehicleCountMap() {
        return vehicleCountMap;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVehicleTypesList(Set<VehicleType> vehicleTypesList) {
        this.vehicleTypesList = vehicleTypesList;
    }

    public void setVehicleCountMap(Map<VehicleType, Integer> vehicleCountMap) {
        this.vehicleCountMap = vehicleCountMap;
    }

    public Map<String, Vehicle> getVehicleMap() {
        return vehicleMap;
    }

    public void setVehicleMap(Map<String, Vehicle> vehicleMap) {
        this.vehicleMap = vehicleMap;
    }

    public Booking getBooking() {
        return booking;
    }

    public String toString() {
        return "[" + name + "]," + "[" + vehicleTypesList +"]," + "[" + vehicleMap + "]";
    }

}

package com.assignment.navi.model;

import com.assignment.navi.model.Enums.VehicleType;

public class Vehicle {
    private String id;
    private Double price;
    private String name;
    private VehicleType vehicleType;

    public Vehicle(String name, Double price, VehicleType vehicleType) {
        this.name = name;
        this.price = price;
        this.vehicleType = vehicleType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}

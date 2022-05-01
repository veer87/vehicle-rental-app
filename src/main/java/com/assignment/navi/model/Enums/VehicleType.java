package com.assignment.navi.model.Enums;

import org.springframework.util.StringUtils;

import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum VehicleType {
    BIKE(0, "BIKE"), CAR(1, "CAR"), BUS(2, "BUS"), VAN(3, "VAN");

    private int id;
    private String name;

    private VehicleType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private static Map<String, VehicleType> reverseLookUpByName = Stream.of(VehicleType.values()).collect(Collectors.toMap(VehicleType::getName, Function.identity()));

    public static VehicleType ofName(String name) { return reverseLookUpByName.get(name.toUpperCase()); }
}

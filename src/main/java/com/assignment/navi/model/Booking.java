package com.assignment.navi.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Booking {
    //BookingEntry bookingEntry = new BookingEntry();

    private final Map<Long, Set<String>> startTimeBookingMap = new HashMap<>();
    private final Map<Long, Set<String>> endTimeBookingMap = new HashMap<>();
    private final Map<Long, Set<String>> timeBookingMap = new HashMap<>();

    private final Set<String> availableVehicleSet = new HashSet<>();

    public Map<Long, Set<String>> getStartTimeBookingMap() {
        return startTimeBookingMap;
    }

    public Map<Long, Set<String>> getEndTimeBookingMap() {
        return endTimeBookingMap;
    }

    public Set<String> getAvailableVehicleSet() {
        return availableVehicleSet;
    }

    public Map<Long, Set<String>> getTimeBookingMap() {
        return timeBookingMap;
    }
}

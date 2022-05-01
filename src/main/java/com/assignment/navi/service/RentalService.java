package com.assignment.navi.service;

import com.assignment.navi.Constants.Common;
import com.assignment.navi.Exceptions.RentalException;
import com.assignment.navi.model.*;
import com.assignment.navi.model.Enums.VehicleType;
import com.assignment.navi.repository.InMemoryDataStore;
import com.assignment.navi.utils.SortUtils;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RentalService {

    private static Logger logger = Logger.getLogger(RentalService.class.getName());

    private static RentalApp rentalAppIndia = InMemoryDataStore.rentalAppMap.get(Common.RENTAL_APP_INDIA);

    public boolean onBoardBranch(String name, String vehicleType) {
        try {
            String[] vehicleTypes = vehicleType.split(",");
            List<VehicleType> vehicleTypeList = Stream.of(vehicleTypes).filter(v -> VehicleType.ofName(v) != null).map(v -> VehicleType.ofName(v)).collect(Collectors.toList());

            Branch branch = rentalAppIndia.getBranches().get(name);

            if (branch == null) branch = new Branch(name, vehicleTypeList);

            rentalAppIndia.getBranches().put(name, branch);


            //logger.log(Level.INFO, rentalAppIndia.getBranches().toString());

            return true;
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return false;
    }

    public boolean onBoardVehicle(String branchName, String type, String vehicleName, String price) {

        try {
            VehicleType vehicleType = VehicleType.ofName(type);
            Branch branch = rentalAppIndia.getBranches().get(branchName);

            if (branch == null) throw new RentalException.BranchException.NotExist("Entered branch does not exist: " + branchName);
            if (vehicleType == null) throw new RentalException.VehicleException.NotValidVehicleTypeException("entered vehicle type does not exit : " + type);
            if (!branch.getVehicleTypesList().contains(vehicleType)) throw new RentalException.VehicleException.NotValidVehicleTypeSupportedByBranchException("entered vehicle type does not supported by given branch : " + type);
            Vehicle vehicle = branch.getVehicleMap().get(vehicleName);

            if (vehicle != null) throw new RentalException.VehicleException.AlreadyExist("Entered Vehicle already exist, can't be added anymore.");

            vehicle = new Vehicle(vehicleName, Double.parseDouble(price), vehicleType);

            branch.getVehicleMap().put(vehicleName, vehicle);
            branch.getVehicleCountMap().put(vehicleType, branch.getVehicleCountMap().getOrDefault(vehicleType, 0) + 1);

            return true;

        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

        return false;
    }

    public Double bookVehicle(String branchId, String type, long startTime, long endTime) {

        try {
            Branch branch = rentalAppIndia.getBranches().get(branchId);

            VehicleType vehicleType = VehicleType.ofName(type);
            Map<String, Vehicle> vehicleMap = branch.getVehicleMap();

            if (branch == null) throw new RentalException.BranchException.NotExist("Entered branch does not exist: " + branchId);

            if (vehicleType == null) throw new RentalException.VehicleException.NotValidVehicleTypeException("entered vehicle type does not exit : " + type);

            if (vehicleMap == null || vehicleMap.size() == 0) throw new RentalException.VehicleException.NoVehicleExist("There is no vehicle for booking for branchId: " + branchId + " -- " + type);

            List<Object> availableVehicleList = getAvailableVehicleList(branchId, startTime, endTime);


            for (Object vehicleName : availableVehicleList) {
                if (vehicleMap.containsKey(vehicleName) && vehicleMap.get(vehicleName).getVehicleType() == vehicleType) {
                    Vehicle vehicle = vehicleMap.get(vehicleName);
                    if (vehicle.getVehicleType() == vehicleType) {
                        // book the vehicle
                        Map<Long, Set<String>> bookingMap = branch.getBooking().getTimeBookingMap();
                        while(startTime <= endTime) {
                            Set<String> vehicleSet = new HashSet<>();
                            if (bookingMap.containsKey(startTime)) vehicleSet = bookingMap.get(startTime);
                            vehicleSet.add((String) vehicleName);
                            bookingMap.put(startTime, vehicleSet);
                            startTime++;
                        }
                        return vehicle.getPrice();
                    }

                }
            }
        }  catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

        return -1.0;

    }

    public List<Object> getAvailableVehicleList (String branchId, long starTime, long endTime) throws RentalException.BranchException.NotExist {
        return getAvailableVehicleList(branchId, starTime, endTime, "price", "asc");
    }

    public List<Object> getAvailableVehicleList (String branchId, long starTime, long endTime, String sortValue, String sortOrder) throws RentalException.BranchException.NotExist{
        Branch branch = rentalAppIndia.getBranches().get(branchId);

        if (branch == null) throw new RentalException.BranchException.NotExist("Entered branch does not exist: " + branchId);

        Set<String> allVehicles = new HashSet<>(branch.getVehicleMap().keySet());
        Map<Long, Set<String>> timeBookingMap = branch.getBooking().getTimeBookingMap();
        Set<String> bookedVehicles = new HashSet<>();

        while(starTime <= endTime) {
            if (timeBookingMap.containsKey(starTime)) bookedVehicles.addAll(timeBookingMap.get(starTime));
            starTime++;
        }
        allVehicles.removeAll(bookedVehicles);// removed all booked vehicles from allVehiclesSet.
        return SortUtils.sort(branch, allVehicles, sortValue, sortOrder);
    }
}

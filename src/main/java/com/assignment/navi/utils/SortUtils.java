package com.assignment.navi.utils;

import com.assignment.navi.model.Branch;

import java.util.*;

public class SortUtils {
    public static List<Object> sort(Branch branch, Set<String> allVehicles, String sortValue, String sortOrder) {
        List<Object> result = Arrays.asList(allVehicles.toArray());
        Comparator<Object> comparatorByPrice = sortOrder.equalsIgnoreCase("asc") ?
                (a, b) -> (int) (branch.getVehicleMap().get(a).getPrice() - branch.getVehicleMap().get(b).getPrice())
                : (a, b) -> (int) (branch.getVehicleMap().get(b).getPrice() - branch.getVehicleMap().get(a).getPrice());
        switch (sortValue) {
            case "price" :
               Collections.sort(result, comparatorByPrice);
                break;
            default:
                break;
        }
        return result;
    }
}

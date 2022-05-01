package com.assignment.navi.repository;

import com.assignment.navi.Constants.Common;
import com.assignment.navi.model.RentalApp;

import java.util.Collections;
import java.util.Map;

public class InMemoryDataStore {
    public static final Map<String, RentalApp> rentalAppMap = Collections.singletonMap(Common.RENTAL_APP_INDIA, new RentalApp(Common.RENTAL_APP_INDIA));


}

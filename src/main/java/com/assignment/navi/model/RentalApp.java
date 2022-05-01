package com.assignment.navi.model;

import java.util.*;

public class RentalApp {
    private String id;
    private String name;
    private Map<String, Branch> branchesMap = new HashMap<>();

    public RentalApp(String name) {
        this.name = name;
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, Branch> getBranches() {
        return branchesMap;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBranches(Map<String, Branch> branches) {
        this.branchesMap = branches;
    }
}

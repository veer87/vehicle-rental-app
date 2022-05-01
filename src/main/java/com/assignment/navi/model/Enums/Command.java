package com.assignment.navi.model.Enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Command {
    ADD_BRANCH(0, "ADD_BRANCH"), ADD_VEHICLE(1, "ADD_VEHICLE"), BOOK(2, "BOOK"), DISPLAY_VEHICLES(3, "DISPLAY_VEHICLES");

    private int id;
    private String name;

    private Command(int id, String name) {
        this.id = id;
        this.name = name;

    }

    private int getId() { return this.id; }
    private String getName() { return this.name; }

    private static Map<Integer, Command> reverseLookupById = Stream.of(Command.values()).collect(Collectors.toMap(Command::getId, Function.identity()));
    private static Map<String, Command> reverseLookupByName = Stream.of(Command.values()).collect(Collectors.toMap(Command::getName, Function.identity()));

    public static Command ofId(int id) { return reverseLookupById.get(id);}
    public static Command ofName(String name) { return reverseLookupByName.get(name); }

}

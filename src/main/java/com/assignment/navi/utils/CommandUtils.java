package com.assignment.navi.utils;

import com.assignment.navi.Exceptions.RentalException;
import com.assignment.navi.model.Enums.Command;
import com.assignment.navi.vehiclerentalapp.VehicleRentalAppApplication;

import java.util.Arrays;

import static com.assignment.navi.model.Enums.Command.*;

public class CommandUtils {

    public static Object parseInput(String input) throws Exception {
        String[] splitBySpace = input.split(" ");

        if (splitBySpace != null && splitBySpace.length > 0) {
            return parseCommand(splitBySpace);

        }
        return null;
    }

    private static Object parseCommand(String[] commandArray) throws Exception{
        Command command = Command.ofName(commandArray[0]);
        String[] remainedInput = Arrays.copyOfRange(commandArray, 1, commandArray.length);
        Object result = null;
        switch (command) {
            case ADD_BRANCH:
                result = parseAddBranchInput(remainedInput);
                break;
            case ADD_VEHICLE:
                result = parseAddVehicleInput(remainedInput);
                break;
            case BOOK:
                result = parseBookInput(remainedInput);
                break;
            case DISPLAY_VEHICLES:
                result = parseDisplayVehiclesInput(remainedInput);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
        return result;
    }

    private static Object parseBookInput(String[] input) throws Exception {
        if (input.length != 4) throw new RentalException.InputParseException.NotValidLength(DISPLAY_VEHICLES + " Input Length is not valid: " + input.length);

        return VehicleRentalAppApplication.rentalService.bookVehicle(input[0], input[1], Long.parseLong(input[2]), Long.parseLong(input[3]));
    }

    private static Object parseDisplayVehiclesInput(String[] input) throws RentalException.InputParseException.NotValidLength, RentalException.BranchException.NotExist {
        if (input.length != 3) throw new RentalException.InputParseException.NotValidLength(DISPLAY_VEHICLES + " Input Length is not valid: " + input.length);

        return VehicleRentalAppApplication.rentalService.getAvailableVehicleList(input[0], Long.parseLong(input[1]), Long.parseLong(input[2]));
    }

    private static Object parseAddVehicleInput(String[] input) throws RentalException.VehicleException.NotValidVehicleInputException {
        if (input.length != 4) throw new RentalException.VehicleException.NotValidVehicleInputException(ADD_VEHICLE + " Input Length is not valid: " + input.length);
        return VehicleRentalAppApplication.rentalService.onBoardVehicle(input[0], input[1], input[2], input[3]);
    }

    private static Object parseAddBranchInput(String[] input) throws RentalException.InputParseException.NotValidLength {
        if (input.length < 1 || input.length > 2) throw new RentalException.InputParseException.NotValidLength(ADD_BRANCH + " Input Length is not valid: " + input.length);

        return VehicleRentalAppApplication.rentalService.onBoardBranch(input[0], input[1]);
    }
}

package com.assignment.navi.Exceptions;


public class RentalException extends BaseRentalException {
    public RentalException(String msg) {
        super(msg);
    }

    public static class InputParseException extends RentalException {
        public InputParseException(String msg) {
            super(msg);
        }

        public static class NotValidLength extends InputParseException {
            public NotValidLength(String msg) {
                super(msg);
            }
        }
    }

    public static class VehicleException extends RentalException {
        public VehicleException(String msg) { super(msg);}

        public static class NotValidVehicleTypeException extends VehicleException {

            public NotValidVehicleTypeException(String msg) {
                super(msg);
            }
        }
        public static class NotValidVehicleTypeSupportedByBranchException extends VehicleException {

            public NotValidVehicleTypeSupportedByBranchException(String msg) {
                super(msg);
            }
        }


        public static class AlreadyExist extends VehicleException {

            public AlreadyExist(String msg) {
                super(msg);
            }
        }

        public static class NoVehicleExist extends VehicleException {

            public NoVehicleExist(String msg) {
                super(msg);
            }
        }

        public static class NotValidVehicleInputException extends VehicleException {

            public NotValidVehicleInputException(String msg) {
                super(msg);
            }
        }
    }

    public static class BranchException extends RentalException {
        public BranchException(String msg) {
            super(msg);
        }

        public static class NotExist extends BranchException {

            public NotExist(String msg) {
                super(msg);
            }
        }
    }
}

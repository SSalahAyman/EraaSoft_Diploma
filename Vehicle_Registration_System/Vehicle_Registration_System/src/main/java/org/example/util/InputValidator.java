package org.example.util;

import org.example.exception.InvalidInputException;
import org.example.exception.MissingMandatoryFieldException;
import org.example.model.Vehicle;

import java.time.LocalDate;

public class InputValidator {

    public static void validateNewVehicle (Vehicle vehicle) {

        validatePlateNumber(vehicle.getPlateNumber());
        validateOwnerName(vehicle.getOwnerName());
        validateVehicleType(vehicle.getVehicleType());
        validateRegisterYear(vehicle.getRegistrationYear());

    }

    public static void validatePlateNumber(String plateNumber){

        if (plateNumber == null || plateNumber.trim().isEmpty()) {

            throw new MissingMandatoryFieldException();

        }

        if (!plateNumber.matches("[A-Za-z0-9-]{3,10}")) {

            throw new InvalidInputException("Plate Number must be 3-10 alphanumeric characters");

        }
    }

    public static void validateOwnerName(String ownerName) {

        if (ownerName == null || ownerName.trim().isEmpty()) {


            throw new MissingMandatoryFieldException();

        }

        if (ownerName.length() < 3) {

            throw new InvalidInputException ("OwnerName must be at least 3 characters");

        }

        if (!ownerName.matches("[A-Za-z ]+")){

            throw new InvalidInputException ("Owner name must contain only letters");

        }
    }

    public static void validateVehicleType (String vehicleType) {

        if (vehicleType == null || vehicleType.trim().isEmpty()) {

            throw new MissingMandatoryFieldException();

        }

        if (!(vehicleType.equalsIgnoreCase("Car")
                ||vehicleType.equalsIgnoreCase("Truck")
                ||vehicleType.equalsIgnoreCase("Motorcycle"))){

            throw new InvalidInputException("Invalid Type. Use : Car, Truck, Motorcycle");

        }
    }

    public static void validateRegisterYear(int registrationYear) {

        int currentYear = LocalDate.now().getYear();

        if (registrationYear < 1990 || registrationYear > currentYear){

            throw new InvalidInputException("Year must be between 1990 and " + currentYear);

        }
    }
}

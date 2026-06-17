package org.example.util;

import org.example.exception.InvalidInputException;
import org.example.exception.MissingMandatoryFieldException;
import org.example.model.Vehicle;

import java.time.LocalDate;
import java.util.Scanner;

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

    public static void validateVehicleTypeChoice(Integer typeChoice) {

        if (typeChoice == null) {

            throw new MissingMandatoryFieldException();

        }

        if (typeChoice < 1 || typeChoice > 3) {

            throw new InvalidInputException(
                    "Invalid vehicle type. Choose 1, 2 or 3.");

        }
    }

    public static void validateRegisterYear(Integer registrationYear) {

        if (registrationYear == null) {

            throw new MissingMandatoryFieldException();

        }

        int currentYear = LocalDate.now().getYear();

        if (registrationYear < 1990 || registrationYear > currentYear){

            throw new InvalidInputException("Year must be between 1990 and " + currentYear);

        }
    }

    public static void validateNumberOfDoors(int doors) {

        if (doors < 0 || doors >=6) {

            throw new InvalidInputException("ERROR: Doors must be between 1 and 6.");

        }

    }

    public static void validateCargoCapacity(double cargoCapacity) {

        if (cargoCapacity < 0 ) {

            throw new InvalidInputException("ERROR: Cargo capacity must be greater than 0.");

        }

    }

    public static void validateEngineType(String engineType) {

        if (engineType.trim().isEmpty()) {

            throw new MissingMandatoryFieldException();

        }

    }
}

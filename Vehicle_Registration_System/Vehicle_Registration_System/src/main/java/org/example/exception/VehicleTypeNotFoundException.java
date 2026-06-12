package org.example.exception;

public class VehicleTypeNotFoundException extends RuntimeException{

    public VehicleTypeNotFoundException(String vehicleType){

        super ("No " + vehicleType + " vehicles found.");

    }
}

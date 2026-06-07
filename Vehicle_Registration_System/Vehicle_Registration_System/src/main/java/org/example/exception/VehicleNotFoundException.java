package org.example.exception;

public class VehicleNotFoundException extends RuntimeException{

    public VehicleNotFoundException () {
        super("There is no any vehicle registered with this plateNumber");
    }
}

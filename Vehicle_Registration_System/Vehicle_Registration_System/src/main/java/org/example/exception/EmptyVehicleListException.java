package org.example.exception;

public class EmptyVehicleListException extends RuntimeException{

    public EmptyVehicleListException (){

        super("No Vehicles registered");

    }
}

package org.example.exception;

public class OwnerNotFoundException extends RuntimeException{

    public OwnerNotFoundException (String ownerName){

        super("No Vehicles Found for Owner : " + ownerName);

    }
}

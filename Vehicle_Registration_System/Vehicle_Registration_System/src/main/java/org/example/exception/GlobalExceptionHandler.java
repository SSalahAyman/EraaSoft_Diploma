package org.example.exception;

public class GlobalExceptionHandler {

    public static void handle(Exception e) {

        if (e instanceof DuplicatePlateException){

            System.out.println("\nERROR : " + e.getMessage());

        } else if (e instanceof VehicleNotFoundException) {

            System.out.println("\nERROR : " + e.getMessage());

        } else if (e instanceof EmptyVehicleListException) {

            System.out.println("\nERROR : " + e.getMessage());

        } else if (e instanceof InvalidInputException) {

            System.out.println("\nERROR : " + e.getMessage());

        } else if (e instanceof MissingMandatoryFieldException) {

            System.out.println("\nERROR : " + e.getMessage());

        } else if (e instanceof NoExpiredRegistrationsException) {

            System.out.println("\nERROR : " + e.getMessage());

        } else if (e instanceof OwnerNotFoundException) {

            System.out.println("\nERROR : " + e.getMessage());

        } else if (e instanceof VehicleTypeNotFoundException) {

            System.out.println("\nERROR : " + e.getMessage());

        } else {

            System.out.println("\nUnexpected Error : " + e.getMessage());
            
        }
    }

}

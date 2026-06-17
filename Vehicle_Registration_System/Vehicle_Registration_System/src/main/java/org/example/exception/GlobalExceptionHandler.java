package org.example.exception;

import java.util.InputMismatchException;

public class GlobalExceptionHandler {

    public static void handle(Exception e) {

        if (e instanceof InputMismatchException) {

            System.out.println("\nERROR : Invalid input type. Please enter a numeric value.");

        } else if (e instanceof NumberFormatException) {

            System.out.println("\nERROR : Invalid input Format. The value must be a number.");

        } else {

            System.out.println("\nERROR : " + e.getMessage());

        }
    }
}

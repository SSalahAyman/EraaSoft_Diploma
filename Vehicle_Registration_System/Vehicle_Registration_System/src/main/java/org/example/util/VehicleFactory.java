package org.example.util;

import org.example.exception.GlobalExceptionHandler;
import org.example.exception.InvalidInputException;
import org.example.exception.MissingMandatoryFieldException;
import org.example.model.Car;
import org.example.model.Motorcycle;
import org.example.model.Truck;
import org.example.model.Vehicle;

import java.util.Scanner;

public class VehicleFactory {

    public static Vehicle createVehicle(Integer typeChoice, String plateNumber, String ownerName, Integer year, String status, Scanner scanner) {

        switch (typeChoice) {

            case 1 :
                while (true){
                    try{
                        System.out.print("Number Of Doors: ");
                        int doors = scanner.nextInt();
                        InputValidator.validateNumberOfDoors(doors);
                        scanner.nextLine(); // clear buffer after successful read
                        return new Car(plateNumber,ownerName,"Car",year,status,doors);
                    } catch (Exception e) {
                        GlobalExceptionHandler.handle(e);
                        scanner.nextLine(); // clear the invalid input
                        // Continue the loop to ask again
                    }

                }


            case 2 :
                while(true){
                    try {
                        System.out.println("Cargo Capacity Tons: ");
                        double cargoCapacity = scanner.nextDouble();
                        InputValidator.validateCargoCapacity(cargoCapacity);
                        scanner.nextLine(); // clear buffer after successful read
                        return new Truck(plateNumber,ownerName,"Truck",year,status,cargoCapacity);
                    } catch (Exception e) {
                        GlobalExceptionHandler.handle(e);
                        scanner.nextLine(); // clear the invalid input
                        // Continue the loop to ask again
                    }

                }

            case 3 :
                while (true){
                    try {
                        System.out.println("Engine Type: ");
                        String engineType = scanner.nextLine();
                        InputValidator.validateEngineType(engineType);
                        return new Motorcycle(plateNumber,ownerName,"Motorcycle",year,status,engineType);
                    } catch (Exception e) {
                        GlobalExceptionHandler.handle(e);
                    }

                }

            default :
                throw new InvalidInputException("Invalid vehicle type");
        }

    }
}

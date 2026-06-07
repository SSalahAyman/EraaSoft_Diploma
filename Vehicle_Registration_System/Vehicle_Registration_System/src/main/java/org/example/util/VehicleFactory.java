package org.example.util;

import org.example.exception.InvalidInputException;
import org.example.model.Car;
import org.example.model.Motorcycle;
import org.example.model.Truck;
import org.example.model.Vehicle;

import java.util.Scanner;

public class VehicleFactory {

    public static Vehicle createVehicle(int typeChoice, String plateNumber, String ownerName, int year, String status, Scanner scanner) {

        switch (typeChoice) {

            case 1 :
                System.out.print("Number Of Doors: ");
                int doors = scanner.nextInt();
                return new Car(plateNumber,ownerName,"Car",year,status,doors);

            case 2 :
                System.out.println("Cargo Capacity Tons: ");
                double cargoCapacity = scanner.nextDouble();
                return new Truck(plateNumber,ownerName,"Truck",year,status,cargoCapacity);

            case 3 :
                System.out.println("Engine Type: ");
                String engineType = scanner.nextLine();
                return new Motorcycle(plateNumber,ownerName,"Motorcycle",year,status,engineType);

            default :
                throw new InvalidInputException("Invalid vehicle type");
        }

    }
}

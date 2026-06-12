package org.example.app.internal_screens;

import org.example.exception.InvalidInputException;
import org.example.model.Vehicle;
import org.example.service.VehicleService;

import java.util.List;
import java.util.Scanner;

public class FilterByTypeScreen implements Screen{

    private VehicleService vehicleService;
    private Scanner scanner;

    public FilterByTypeScreen(VehicleService vehicleService, Scanner scanner) {
        this.vehicleService = vehicleService;
        this.scanner = scanner;
    }

    @Override
    public void showScreen() {

        System.out.println("""
                
                ===== FILTER BY TYPE =====
                
                1. Car
                2. Truck
                3. Motorcycle
                """);

        System.out.println("Enter choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        String vehicleType;

         switch (choice) {

            case 1 :
                vehicleType = "Car";
                break;

             case 2 :
                 vehicleType = "Truck";
                 break;

             case 3 :
                 vehicleType = "Motorcycle";
                 break;

             default:
                 throw new InvalidInputException("Invalid Vehicle Type");
        };

        List<Vehicle> filteredVehicles = vehicleService.filterByType(vehicleType);

            System.out.println(
                    "\n===== " + vehicleType.toUpperCase()
                            + " VEHICLES =====");

            filteredVehicles.stream().forEach(System.out::println);

        System.out.println("\nPress Enter To Continue...");
        scanner.nextLine();
    }
}

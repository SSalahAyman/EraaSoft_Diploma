package org.example.app.internal_screens;

import org.example.model.Vehicle;
import org.example.service.VehicleService;
import org.example.util.VehicleFactory;

import java.util.Scanner;

public class RegisterVehicleScreen implements Screen {

    private VehicleService vehicleService;
    private Scanner scanner;

    public RegisterVehicleScreen(VehicleService vehicleService, Scanner scanner) {
        this.vehicleService = vehicleService;
        this.scanner = scanner;
    }

    @Override
    public void showScreen() {

        System.out.println("\n==== Register Vehicle ====\n");

        System.out.println("Enter Plate Number : ");
        String plateNumber = scanner.nextLine();

        System.out.println("Enter the Owner Name : ");
        String ownerName = scanner.nextLine();

        System.out.println("Enter the registrationYear : ");
        int year = scanner.nextInt();
        scanner.nextLine();  // تنظيف الـ Buffer

        System.out.println("""
            1. Car
            2. Truck
            3. Motorcycle
            """);

        int typeChoice = scanner.nextInt();
        scanner.nextLine(); // تنظيف الـ Buffer

       Vehicle vehicle = VehicleFactory.createVehicle(typeChoice,plateNumber,ownerName,year,"ACTIVE",scanner);

        vehicleService.RegisterVehicle(vehicle);

        System.out.println("Vehicle Registered Successfully");

    }
}

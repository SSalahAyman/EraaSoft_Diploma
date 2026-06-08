package org.example.app.internal_screens;

import org.example.service.VehicleService;

import java.util.Scanner;

public class UpdateOwnerScreen implements Screen{

    private VehicleService vehicleService;
    private Scanner scanner;

    public UpdateOwnerScreen(VehicleService vehicleService, Scanner scanner) {
        this.vehicleService = vehicleService;
        this.scanner = scanner;
    }

    @Override
    public void showScreen() {

        System.out.println("\n===== UPDATE OWNER =====");

        System.out.println("Plate Number: ");

        String plateNumber = scanner.nextLine();

        System.out.println("New Owner name: ");

        String newOwner = scanner.nextLine();

        vehicleService.updateOwnerName(plateNumber,newOwner);

        System.out.println("\nOwner Updated Successfully.");

        System.out.println("\nPress Enter To Continue...");

        scanner.nextLine();

    }
}

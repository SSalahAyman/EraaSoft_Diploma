package org.example.app.internal_screens;

import org.example.service.VehicleService;

import java.util.Scanner;

public class DeleteVehicleScreen implements Screen{

    private VehicleService vehicleService;
    private Scanner scanner;

    public DeleteVehicleScreen(VehicleService vehicleService, Scanner scanner) {
        this.vehicleService = vehicleService;
        this.scanner = scanner;
    }

    @Override
    public void showScreen() {

        System.out.println("\n===== DELETE VEHICLE =====");

        System.out.println("Enter Plate Number: ");

        String plateNumber = scanner.nextLine();

        vehicleService.deleteVehicle(plateNumber);

        System.out.println("\nVehicle Deleted Successfully.");

        System.out.println("\nPress Enter To Continue...");
        scanner.nextLine();

    }
}

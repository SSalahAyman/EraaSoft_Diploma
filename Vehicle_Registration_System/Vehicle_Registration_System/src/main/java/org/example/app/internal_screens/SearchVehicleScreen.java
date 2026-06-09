package org.example.app.internal_screens;

import org.example.model.Vehicle;
import org.example.service.VehicleService;

import java.util.Scanner;

public class SearchVehicleScreen implements Screen{

    private VehicleService vehicleService;
    private Scanner scanner;

    public SearchVehicleScreen(VehicleService vehicleService, Scanner scanner) {
        this.vehicleService = vehicleService;
        this.scanner = scanner;
    }

    @Override
    public void showScreen() {

        System.out.println("\n===== SEARCH VEHICLE =====");

        System.out.print("Enter Plate Number: ");

        String plateNumber = scanner.nextLine();

        Vehicle vehicle = vehicleService.searchByPlateNumber(plateNumber);

        System.out.println("\nVehicle Found:");

        System.out.println(vehicle);

        System.out.println("\nPress Enter To Continue...");
        scanner.nextLine();
    }
}

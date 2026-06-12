package org.example.app.internal_screens;

import org.example.model.Vehicle;
import org.example.service.VehicleService;

import java.util.List;
import java.util.Scanner;

public class OwnerHistoryScreen implements Screen{

    private VehicleService vehicleService;
    private Scanner scanner;

    public OwnerHistoryScreen(VehicleService vehicleService, Scanner scanner) {
        this.vehicleService = vehicleService;
        this.scanner = scanner;
    }

    @Override
    public void showScreen() {

        System.out.print("Enter Owner Name: ");

        String ownerName = scanner.nextLine();

        List<Vehicle> vehicles = vehicleService.getVehiclesByOwner(ownerName);

        vehicles.stream().forEach(System.out::println);

        System.out.println("\nPress Enter To Continue...");
        scanner.nextLine();
    }
}

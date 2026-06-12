package org.example.app.internal_screens;

import org.example.model.Vehicle;
import org.example.service.VehicleService;

import java.util.List;
import java.util.Scanner;

public class ListVehicleScreen implements Screen{

    private VehicleService vehicleService;
    private Scanner scanner;

    public ListVehicleScreen(VehicleService vehicleService, Scanner scanner) {
        this.vehicleService = vehicleService;
        this.scanner = scanner;
    }

    @Override
    public void showScreen()  {

        System.out.println("\n===== ALL REGISTERED VEHICLES =====");

        List<Vehicle> vehicles = vehicleService.getAllVehicles();

            vehicles.stream().forEach(System.out::println);

        System.out.println("\nPress Enter To Continue...");
        scanner.nextLine();

    }
}

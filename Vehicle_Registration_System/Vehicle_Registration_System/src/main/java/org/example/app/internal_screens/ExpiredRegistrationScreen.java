package org.example.app.internal_screens;

import org.example.model.Vehicle;
import org.example.service.VehicleService;

import java.util.List;
import java.util.Scanner;


public class ExpiredRegistrationScreen implements Screen{

    private VehicleService vehicleService;
    private Scanner scanner;

    public ExpiredRegistrationScreen(VehicleService vehicleService, Scanner scanner) {
        this.vehicleService = vehicleService;
        this.scanner = scanner;
    }

    @Override
    public void showScreen() {

        System.out.println("\n===== EXPIRED REGISTRATIONS =====");

        List<Vehicle> expiredRegistrations = vehicleService.getExpiredRegistrations();
        
        expiredRegistrations.stream().forEach(System.out::println);

        System.out.println("\nPress Enter To Continue...");
        scanner.nextLine();
    }
}

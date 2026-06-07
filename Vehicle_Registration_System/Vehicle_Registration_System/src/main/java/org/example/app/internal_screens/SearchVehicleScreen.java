package org.example.app.internal_screens;

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

    }
}

package org.example.app.internal_screens;

import org.example.service.VehicleService;

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

    }
}

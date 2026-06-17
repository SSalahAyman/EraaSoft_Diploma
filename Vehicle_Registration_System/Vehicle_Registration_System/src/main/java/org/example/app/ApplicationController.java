package org.example.app;

import org.example.app.internal_screens.*;
import org.example.exception.GlobalExceptionHandler;
import org.example.service.StatisticsService;
import org.example.service.VehicleService;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 this class runs as the controller of the application that represent the MainScreen of the console application
  and control on switching between the internal screens , and accept any exceptions that can throw from any internal screen or any class internally and handle it
 */
public class ApplicationController {

     private VehicleService vehicleService;
     private StatisticsService statisticsService;
    private Scanner scanner;
     private RegisterVehicleScreen registerScreen;
     private SearchVehicleScreen searchScreen;
     private UpdateOwnerScreen updateOwnerScreen;
     private DeleteVehicleScreen deleteScreen;
     private ListVehicleScreen listScreen;
     private FilterByTypeScreen filterScreen;
     private OwnerHistoryScreen ownerHistoryScreen;
     private ExpiredRegistrationScreen expiredScreen;
     private StatisticsScreen statisticsScreen;

     public ApplicationController(VehicleService vehicleService,StatisticsService statisticsService , Scanner scanner) {
         this.vehicleService = vehicleService;
         this.statisticsService = statisticsService;
         this.scanner = scanner;
         registerScreen = new RegisterVehicleScreen(vehicleService,scanner);
         searchScreen = new SearchVehicleScreen(vehicleService,scanner);
         updateOwnerScreen = new UpdateOwnerScreen(vehicleService,scanner);
         deleteScreen = new DeleteVehicleScreen(vehicleService,scanner);
         listScreen = new ListVehicleScreen(vehicleService,scanner);
         filterScreen = new FilterByTypeScreen(vehicleService,scanner);
         ownerHistoryScreen = new OwnerHistoryScreen(vehicleService,scanner);
         expiredScreen = new ExpiredRegistrationScreen(vehicleService,scanner);
         statisticsScreen = new StatisticsScreen(statisticsService,scanner);
     }

    public void StartApplication() {


        while (true) {

            try {

                showMenu();

                int choice = scanner.nextInt();
                scanner.nextLine(); // clear buffer

                switch (choice) {

                    case 1:
                        registerScreen.showScreen();
                        break;

                    case 2:
                        searchScreen.showScreen();
                        break;

                    case 3:
                        updateOwnerScreen.showScreen();
                        break;

                    case 4:
                        deleteScreen.showScreen();
                        break;

                    case 5:
                        listScreen.showScreen();
                        break;

                    case 6:
                        filterScreen.showScreen();
                        break;

                    case 7:
                        ownerHistoryScreen.showScreen();
                        break;

                    case 8:
                        expiredScreen.showScreen();
                        break;

                    case 9:
                        statisticsScreen.showScreen();
                        break;

                    case 0:
                        return;

                    default:
                        System.out.println("Invalid Choice!");
                }

            } catch (Exception e) {

                GlobalExceptionHandler.handle(e);

                // Clear the Scanner buffer only when InputMismatchException occurs.
                // In this case, the invalid input entered by the user remains inside the buffer because methods like nextInt() or nextDouble() cannot consume it.
                // If we don't remove that invalid value, the same exception will be thrown again
                // in the next iteration, causing an infinite loop.
                //
                // For other exceptions (e.g. VehicleNotFoundException), the input has already been consumed and the buffer is empty.
                // Calling nextLine() in those cases would unnecessarily wait for additional user input and make the program appear frozen.
                if (e instanceof InputMismatchException) {
                    // Clear invalid input from Scanner buffer
                    scanner.nextLine();
                }
            }
        }
    }

    private void showMenu(){

        System.out.println("""
                ========================================
                VEHICLE REGISTRATION SYSTEM v1.0
                ========================================
                1. Register New Vehicle
                2. Search Vehicle by Plate
                3. Update Owner Name
                4. Delete Vehicle
                5. List All Vehicles
                6. Filter by Vehicle Type
                7. Show Owner History
                8. Show Expired Registrations
                9. Statistics Report
                0. Exit
                ========================================
                """);

    }
}

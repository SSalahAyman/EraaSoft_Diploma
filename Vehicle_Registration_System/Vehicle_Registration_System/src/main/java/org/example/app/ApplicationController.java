package org.example.app;

import org.example.app.internal_screens.*;
import org.example.service.VehicleService;

import java.util.Scanner;

/*
 this class runs as the controller of the application that represent the MainScreen of the console application
  and control on switching between the internal screens , and accept any exceptions that can throw from any internal screen or any class internally and handle it
 */
public class ApplicationController {

     private VehicleService vehicleService;
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

     public ApplicationController(VehicleService vehicleService,Scanner scanner) {
         this.vehicleService = vehicleService;
         this.scanner = scanner;
         registerScreen = new RegisterVehicleScreen(vehicleService,scanner);
         searchScreen = new SearchVehicleScreen(vehicleService,scanner);
         updateOwnerScreen = new UpdateOwnerScreen(vehicleService,scanner);
         deleteScreen = new DeleteVehicleScreen(vehicleService,scanner);
         listScreen = new ListVehicleScreen(vehicleService,scanner);
         filterScreen = new FilterByTypeScreen(vehicleService,scanner);
         ownerHistoryScreen = new OwnerHistoryScreen(vehicleService,scanner);
         expiredScreen = new ExpiredRegistrationScreen(vehicleService,scanner);
         statisticsScreen = new StatisticsScreen(vehicleService,scanner);
     }

    public void StartApplication(){

        while (true){

            showMenu();

            int choice = scanner.nextInt();

            switch(choice) {

                case 1 :
                    registerScreen.showScreen();
                    break;

                case 2 :
                    searchScreen.showScreen();
                    break;

                case 3 :
                    updateOwnerScreen.showScreen();
                    break;

                case 4 :
                    deleteScreen.showScreen();
                    break;

                case 5 :
                    listScreen.showScreen();
                    break;

                case 6 :
                    filterScreen.showScreen();
                    break;

                case 7 :
                    ownerHistoryScreen.showScreen();
                    break;

                case 8 :
                    expiredScreen.showScreen();
                    break;

                case 9 :
                    statisticsScreen.showScreen();
                    break;

                case 0 :
                    return;
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

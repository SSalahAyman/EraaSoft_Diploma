package org.example.app.internal_screens;

import org.example.exception.GlobalExceptionHandler;
import org.example.exception.MissingMandatoryFieldException;
import org.example.model.Vehicle;
import org.example.service.VehicleService;
import org.example.util.InputValidator;
import org.example.util.VehicleFactory;

import java.util.Scanner;

public class RegisterVehicleScreen implements Screen {

    private VehicleService vehicleService;
    private Scanner scanner;

    public RegisterVehicleScreen(VehicleService vehicleService, Scanner scanner) {
        this.vehicleService = vehicleService;
        this.scanner = scanner;
    }

    @Override
    public void showScreen() {

        System.out.println("\n==== Register Vehicle ====\n");

        // read plateNumber
        String plateNumber;
        while (true) {

            try {

                System.out.print("Enter Plate Number : ");
                plateNumber = scanner.nextLine();

                InputValidator.validatePlateNumber(plateNumber);

                break;
            } catch (Exception e) {

                GlobalExceptionHandler.handle(e);
            }
        }

        // read OwnerName
        String ownerName;
        while (true) {

            try{

                System.out.print("Enter the Owner Name : ");
                ownerName = scanner.nextLine();

                InputValidator.validateOwnerName(ownerName);
                break;
            } catch (Exception e) {

                GlobalExceptionHandler.handle(e);

            }
        }

        // read RegistrationYear
        Integer year;
        while (true) {

            try {

                System.out.print("Enter the registrationYear : ");
                String input = scanner.nextLine();
                year =  input.trim().isEmpty() ? null : Integer.parseInt(input);

                InputValidator.validateRegisterYear(year);

                break;
            } catch (Exception e) {

                GlobalExceptionHandler.handle(e);

            }
        }

        // read VehicleType
        Integer typeChoice;
        while (true){

            try {

                System.out.print("""
                    1. Car
                    2. Truck
                    3. Motorcycle
                    """);
                String inputChoice = scanner.nextLine();
                typeChoice = inputChoice.trim().isEmpty() ? null : Integer.parseInt(inputChoice);

                InputValidator.validateVehicleTypeChoice(typeChoice);

                break;
            }catch (Exception e) {

                GlobalExceptionHandler.handle(e);

            }
        }

       Vehicle vehicle = VehicleFactory.createVehicle(typeChoice,plateNumber,ownerName,year,"ACTIVE",scanner);

        vehicleService.RegisterVehicle(vehicle);

        System.out.println("Vehicle Registered Successfully");

    }

    private String readInput(String message) {

        while (true) {

            try {

                System.out.print(message);
                return scanner.nextLine();

            } catch (Exception e) {

                GlobalExceptionHandler.handle(e);

            }
        }
    }

    private Integer readInteger(String message) {

        while (true) {

            try {

                System.out.print(message);

                String input = scanner.nextLine();

                return input.trim().isEmpty()
                        ? null
                        : Integer.parseInt(input);

            } catch (Exception e) {

                GlobalExceptionHandler.handle(e);

            }
        }
    }

}

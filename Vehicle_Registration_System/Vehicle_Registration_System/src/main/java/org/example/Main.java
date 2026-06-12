package org.example;

import org.example.app.ApplicationController;
import org.example.repo.VehicleRepo;
import org.example.repo.impl.VehicleRepoImpl;
import org.example.service.VehicleService;
import org.example.service.impl.VehicleServiceImpl;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        // create object from VehicleRepository
        VehicleRepo vehicleRepo = new VehicleRepoImpl();

        // create object from VehicleService and put the object of VehicleRepository to it in his constructor
        VehicleService vehicleService = new VehicleServiceImpl(vehicleRepo);

        // create new Scanner & object from MainScreenController and put the scanner object & VehicleService to it in his constructor
        Scanner scanner = new Scanner(System.in);
        ApplicationController applicationController = new ApplicationController(vehicleService,scanner);

        // then , call the startApplication method from MainScreenController to startApplication & show the MainMenu
        applicationController.StartApplication();

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Age: ");
//        int age = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.println("Full Name: ");
//        String fullName = scanner.nextLine();
//
//        System.out.println("Salary: ");
//        double salary = scanner.nextDouble();
//        // scanner.nextLine();
//
//        System.out.println("Address: ");
//        String address = scanner.nextLine();
//
//        System.out.print(fullName);

    }
}
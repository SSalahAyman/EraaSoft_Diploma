package org.example.app.internal_screens;

import org.example.model.StatisticsReport;
import org.example.service.StatisticsService;
import org.example.service.VehicleService;

import java.util.Scanner;

public class StatisticsScreen implements Screen{

    private StatisticsService statisticsService;
    private Scanner scanner;

    public StatisticsScreen(StatisticsService statisticsService, Scanner scanner) {
        this.statisticsService = statisticsService;
        this.scanner = scanner;
    }

    @Override
    public void showScreen() {

        StatisticsReport report = statisticsService.getStatistics();

        System.out.println(
                "\n========== REGISTRATION STATISTICS ==========");

        System.out.printf(
                "Total Vehicles : %d%n",
                report.getTotalVehicles());

        System.out.printf(
                "Average Year : %.0f%n",
                report.getAverageYear());

        System.out.printf(
                "Newest Vehicle : %d%n",
                report.getNewestVehicle());

        System.out.printf(
                "Oldest Vehicle : %d%n",
                report.getOldestVehicle());

        System.out.println(
                "----------------------------------------------");

        System.out.println("Vehicles by Type:");

        report.getVehicleByType()
                .forEach((type, count) ->
                        System.out.printf("%s : %d%n", type, count));

        System.out.println(
                "----------------------------------------------");

        System.out.printf(
                "ACTIVE vehicles : %d%n",
                report.getActiveVehicles());

        System.out.printf(
                "EXPIRED vehicles : %d%n",
                report.getExpiredVehicles());

        System.out.println(
                "==============================================");

        System.out.println("\nPress Enter To Continue...");
        scanner.nextLine();
    }
}

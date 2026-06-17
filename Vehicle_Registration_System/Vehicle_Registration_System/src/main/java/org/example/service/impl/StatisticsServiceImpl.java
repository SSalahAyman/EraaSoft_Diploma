package org.example.service.impl;

import org.example.exception.EmptyVehicleListException;
import org.example.model.StatisticsReport;
import org.example.model.Vehicle;
import org.example.repo.VehicleRepo;
import org.example.service.StatisticsService;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsServiceImpl implements StatisticsService {

    private VehicleRepo vehicleRepo;

    public StatisticsServiceImpl (VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    @Override
    public StatisticsReport getStatistics() {

        List<Vehicle> vehicles = vehicleRepo.findAll();

        if(vehicles.isEmpty()) {
            throw new EmptyVehicleListException();
        }

        IntSummaryStatistics stats = vehicles.stream()
                .mapToInt(Vehicle::getRegistrationYear)
                .summaryStatistics();

        Map<String, Long> byType = vehicles.stream()
                .collect(Collectors.groupingBy(Vehicle::getVehicleType,
                        Collectors.counting()));

        Map<Boolean, Long> byStatus = vehicles.stream()
                .collect(Collectors.partitioningBy(
                        v -> v.getStatus().equals("ACTIVE"),
                        Collectors.counting()));

        return new StatisticsReport(
          stats.getCount(),
          stats.getAverage(),
          stats.getMax(),
          stats.getMin(),
          byType,
          byStatus.get(true),
          byStatus.get(false)
        );

    }
}

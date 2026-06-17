package org.example.model;

import java.util.Map;

public class StatisticsReport {

    private long totalVehicles;
    private double averageYear;
    private int newestVehicle;
    private int oldestVehicle;

    private Map<String,Long> vehicleByType;

    private long activeVehicles;
    private long expiredVehicles;


    public StatisticsReport(long totalVehicles, double averageYear, int newestVehicle, int oldestVehicle, Map<String, Long> vehicleByType, long activeVehicles, long expiredVehicles) {
        this.totalVehicles = totalVehicles;
        this.averageYear = averageYear;
        this.newestVehicle = newestVehicle;
        this.oldestVehicle = oldestVehicle;
        this.vehicleByType = vehicleByType;
        this.activeVehicles = activeVehicles;
        this.expiredVehicles = expiredVehicles;
    }

    public long getTotalVehicles() {
        return totalVehicles;
    }

    public double getAverageYear() {
        return averageYear;
    }

    public int getNewestVehicle() {
        return newestVehicle;
    }

    public int getOldestVehicle() {
        return oldestVehicle;
    }

    public Map<String, Long> getVehicleByType() {
        return vehicleByType;
    }

    public long getActiveVehicles() {
        return activeVehicles;
    }

    public long getExpiredVehicles() {
        return expiredVehicles;
    }


}

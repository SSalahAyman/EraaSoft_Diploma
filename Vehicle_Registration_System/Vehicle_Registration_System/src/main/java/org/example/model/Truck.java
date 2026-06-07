package org.example.model;

public class Truck extends Vehicle {

    private Double cargoCapacityTons;

    public Truck(String plateNumber, String ownerName, String vehicleType, Integer registrationYear, String status, Double cargoCapacityTons) {
        super(plateNumber, ownerName, vehicleType, registrationYear, status);
        this.cargoCapacityTons = cargoCapacityTons;
    }

    @Override
    public String getRegistrationLabel() {
        return "Commercial Truck - Cargo :"+cargoCapacityTons +" tons";
    }

    public Double getCargoCapacityTons() {
        return cargoCapacityTons;
    }

    @Override
    public String toString() {
        return super.toString()
                + " | CargoCapacity: "
                + cargoCapacityTons
                +" tons";
    }
}

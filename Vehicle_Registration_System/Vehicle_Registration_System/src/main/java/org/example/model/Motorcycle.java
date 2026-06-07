package org.example.model;

public class Motorcycle extends Vehicle{

    String engineType;

    public Motorcycle(String plateNumber, String ownerName, String vehicleType, Integer registrationYear, String status, String engineType) {
        super(plateNumber, ownerName, vehicleType, registrationYear, status);
        this.engineType = engineType;
    }

    @Override
    public String getRegistrationLabel() {
        return "Motorcycle - Engine: " + engineType;
    }

    public String getEngineType() {
        return engineType;
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Engine Type: "
                + engineType;
    }
}

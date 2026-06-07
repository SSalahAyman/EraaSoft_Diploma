package org.example.model;

public class Car extends Vehicle{

    private Integer numberOfDoors = 4;

    public Car(String plateNumber, String ownerName, String vehicleType, Integer registrationYear, String status, Integer numberOfDoors) {
        super(plateNumber, ownerName, "Car", registrationYear, status);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String getRegistrationLabel() {
        return "Passenger Car - Doors: "+numberOfDoors;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Doors: "
                + numberOfDoors;
    }
}

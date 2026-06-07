package org.example.model;

public abstract class Vehicle {

    // Declare the attributes of any type of vehicle
    private String plateNumber;

    private  String ownerName;

    private String vehicleType;

    private Integer registrationYear;

    private String status;

    // Declare the constructor that can any subClass of this class uses it
    public Vehicle(String plateNumber, String ownerName, String vehicleType, Integer registrationYear, String status) {
        this.plateNumber = plateNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationYear = registrationYear;
        this.status = status;
    }

    public Vehicle() {
    }

    // Define abstract method
    public abstract String getRegistrationLabel();

    // Define getters & setters
    public String getPlateNumber() {
        return plateNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public Integer getRegistrationYear() {
        return registrationYear;
    }

    public String getStatus() {
        return status;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "[" + plateNumber + "] | "
                + vehicleType
                + " | Owner: "
                + ownerName
                + " | Year: "
                + registrationYear
                + " | Status: "
                + status;
    }
}

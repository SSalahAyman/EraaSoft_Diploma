package org.example.service;

import org.example.model.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> getAllVehicles();

    void RegisterVehicle(Vehicle vehicle);

    Vehicle searchByPlateNumber(String plateNumber);

    void deleteVehicle(String plateNumber);

    void updateOwner(String plateNumber,String newOwner);


}

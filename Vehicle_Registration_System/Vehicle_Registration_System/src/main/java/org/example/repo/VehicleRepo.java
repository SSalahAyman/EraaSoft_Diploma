package org.example.repo;

import org.example.model.Vehicle;

import java.util.List;

public interface VehicleRepo {

    List<Vehicle> findAll(); //

    void saveVehicle(Vehicle vehicle); //

    Vehicle findByPlateNumber(String plateNumber); //

    void deleteVehicle(Vehicle vehicle); //

    void updateOwner(String plateNumber,String newOwner);
}

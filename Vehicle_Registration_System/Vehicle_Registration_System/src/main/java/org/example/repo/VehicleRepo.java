package org.example.repo;

import org.example.model.Vehicle;

import java.util.List;

// class it main objective is to [ save(),find(),delete(),findAll() ]

// we don't do here method to [updateOwnerName] because there is no any interact with any of the three collections that defined in Repo , and just we setOwnerName with set method of model

public interface VehicleRepo {

    List<Vehicle> findAll(); //

    void saveVehicle(Vehicle vehicle); //

    Vehicle findByPlateNumber(String plateNumber); //

    void deleteVehicle(Vehicle vehicle); //

    //void updateOwnerByPlateNumber(Vehicle vehicle ,String newOwner);

    List<Vehicle> filterByType(String vehicleType);

    List<Vehicle> findByOwnerName(String ownerName);

    List<Vehicle> findExpiredRegistrations(int currentYear);
}

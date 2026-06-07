package org.example.repo.impl;

import org.example.model.Vehicle;
import org.example.repo.VehicleRepo;

import java.util.*;

public class VehicleRepoImpl implements VehicleRepo {

    private List<Vehicle> vehicleList = new ArrayList<>();

    private Map<String ,Vehicle> plateIndex = new HashMap<>();

    private Set<String> registeredPlates = new HashSet<>();


    @Override
    public List<Vehicle> findAll() {
        return vehicleList;
    }

    @Override
    public void saveVehicle(Vehicle vehicle) {

    }

    @Override
    public Vehicle findByPlateNumber(String plateNumber) {


        return null;
    }

    @Override
    public void deleteVehicle(Vehicle vehicle) {

    }

    @Override
    public void updateOwner(String plateNumber, String newOwner) {

    }
}

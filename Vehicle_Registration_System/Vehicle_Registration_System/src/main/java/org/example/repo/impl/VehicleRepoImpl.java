package org.example.repo.impl;

import org.example.model.Vehicle;
import org.example.repo.VehicleRepo;
import org.example.util.PlateNormalizer;

import java.util.*;

public class VehicleRepoImpl implements VehicleRepo {

    private List<Vehicle> vehicleList = new ArrayList<>();

    private Map<String,Vehicle> plateIndex = new HashMap<>();

    private Set<String> registeredPlates = new HashSet<>();


    @Override
    public List<Vehicle> findAll() {

        return Collections.unmodifiableList(vehicleList);

    }

    @Override
    public void saveVehicle(Vehicle vehicle) {

        String normalizedPlate = PlateNormalizer.normalize(vehicle.getPlateNumber());

        vehicleList.add(vehicle);

        plateIndex.put(normalizedPlate,vehicle);

        registeredPlates.add(normalizedPlate);

    }

    @Override
    public Vehicle findByPlateNumber(String plateNumber) {

        String normalizedPlate = PlateNormalizer.normalize(plateNumber);

        return plateIndex.get(normalizedPlate);

    }

    @Override
    public void deleteVehicle(Vehicle vehicle) {

        String normalizedPlate = PlateNormalizer.normalize(vehicle.getPlateNumber());

        vehicleList.remove(vehicle);

        plateIndex.remove(normalizedPlate);

        registeredPlates.remove(normalizedPlate);

    }

//    @Override
//    public void updateOwnerByPlateNumber(Vehicle vehicle, String newOwner) {
//
//        vehicle.setOwnerName(newOwner);
//    }
}

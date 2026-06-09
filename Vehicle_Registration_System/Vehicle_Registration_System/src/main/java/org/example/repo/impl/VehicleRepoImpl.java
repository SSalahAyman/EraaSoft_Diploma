package org.example.repo.impl;

import org.example.model.Vehicle;
import org.example.repo.VehicleRepo;
import org.example.util.Normalizer;

import java.util.*;
import java.util.stream.Collectors;

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

        String normalizedPlate = Normalizer.normalizePlate(vehicle.getPlateNumber());

        vehicleList.add(vehicle);

        plateIndex.put(normalizedPlate,vehicle);

        registeredPlates.add(normalizedPlate);

    }

    @Override
    public Vehicle findByPlateNumber(String plateNumber) {

        String normalizedPlate = Normalizer.normalizePlate(plateNumber);

        return plateIndex.get(normalizedPlate);

    }

    @Override
    public void deleteVehicle(Vehicle vehicle) {

        String normalizedPlate = Normalizer.normalizePlate(vehicle.getPlateNumber());

        vehicleList.remove(vehicle);

        plateIndex.remove(normalizedPlate);

        registeredPlates.remove(normalizedPlate);

    }


//    @Override
//    public void updateOwnerByPlateNumber(Vehicle vehicle, String newOwner) {
//
//        vehicle.setOwnerName(newOwner);
//    }

    @Override
    public List<Vehicle> filterByType(String vehicleType) {

        return vehicleList.stream().filter(vehicle -> vehicle.getVehicleType().equalsIgnoreCase(vehicleType))
                .collect(Collectors.toList());

    }

    @Override
    public List<Vehicle> findByOwnerName(String ownerName) {

        String normalizedOwner = Normalizer.normalizeOwner(ownerName);

        // ex : if we have "Ahmed Ali" ,"Ahmed Mohamed" ,"Mohamed Ahmed", "Ali Hassan" / AND user enter "ahmed" / So the returned vehicles that owned by "Ahmed Ali" ,"Ahmed Mohamed" ,"Mohamed Ahmed"
        return vehicleList.stream().filter(vehicle -> vehicle.getOwnerName().toLowerCase().contains(normalizedOwner))
                .collect(Collectors.toList());


    }

    @Override
    public List<Vehicle> findExpiredRegistrations(int currentYear) {

        return vehicleList.stream().filter(vehicle -> currentYear - vehicle.getRegistrationYear() >5 )
                .collect(Collectors.toList());

    }

}

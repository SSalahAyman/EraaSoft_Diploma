package org.example.service.impl;

import org.example.exception.DuplicatePlateException;
import org.example.exception.VehicleNotFoundException;
import org.example.model.Vehicle;
import org.example.repo.VehicleRepo;
import org.example.service.VehicleService;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class VehicleServiceImpl implements VehicleService {

    private VehicleRepo vehicleRepo;

    public VehicleServiceImpl(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    @Override
    public List<Vehicle> getAllVehicles() {

        List<Vehicle> vehicles = vehicleRepo.findAll();

        return vehicles;

    }

    @Override
    public void RegisterVehicle(Vehicle vehicle) {

        // validation


        // check on the inputPlate if there is already registered with existing vehicle or not
        Vehicle existingVehicle  = vehicleRepo.findByPlateNumber(vehicle.getPlateNumber());

        if(Objects.nonNull(existingVehicle)){
            throw new DuplicatePlateException();
        }

        // call the method from VehicleRepo to save the vehicle with all info into the list
        vehicleRepo.saveVehicle(vehicle);
    }

    @Override
    public Vehicle searchByPlateNumber(String plateNumber) {

        Vehicle vehicle = vehicleRepo.findByPlateNumber(plateNumber);

        if(Objects.isNull(vehicle)){

            throw new VehicleNotFoundException();

        }

        return vehicle;
    }

    @Override
    public void deleteVehicle(String plateNumber) {

        Vehicle vehicle = searchByPlateNumber(plateNumber);

        vehicleRepo.deleteVehicle(vehicle);

    }

    @Override
    public void updateOwnerName(String plateNumber, String newOwner) {

        Vehicle vehicle = searchByPlateNumber(plateNumber);

        vehicle.setOwnerName(newOwner);

    }

    @Override
    public List<Vehicle> filterByType(String vehicleType) {

        List<Vehicle> filteredVehicles = vehicleRepo.filterByType(vehicleType);

        return filteredVehicles;

    }

    @Override
    public List<Vehicle> getVehiclesByOwner(String ownerName) {

        List<Vehicle> vehicles = vehicleRepo.findByOwnerName(ownerName);

        return vehicles;
    }

    @Override
    public List<Vehicle> getExpiredRegistrations() {

        int currentYear = LocalDate.now().getYear();

        List<Vehicle> expiredRegistrations = vehicleRepo.findExpiredRegistrations(currentYear);

        return expiredRegistrations;

    }


}

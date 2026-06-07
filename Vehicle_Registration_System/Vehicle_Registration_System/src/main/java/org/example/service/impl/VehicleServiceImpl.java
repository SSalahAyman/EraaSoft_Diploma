package org.example.service.impl;

import org.example.exception.DuplicatePlateException;
import org.example.exception.VehicleNotFoundException;
import org.example.model.Vehicle;
import org.example.repo.VehicleRepo;
import org.example.service.VehicleService;
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
    public void updateOwner(String plateNumber, String newOwner) {

        Vehicle vehicle = searchByPlateNumber(plateNumber);

        vehicleRepo.updateOwner(plateNumber,newOwner);
    }
}

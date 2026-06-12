package org.example.exception;

import org.example.util.Normalizer;

public class VehicleNotFoundException extends RuntimeException{

    public VehicleNotFoundException (String plateNumber) {
        super("There is no vehicle registered with plate number ["
                + Normalizer.normalizePlate(plateNumber) + "]");

    }
}

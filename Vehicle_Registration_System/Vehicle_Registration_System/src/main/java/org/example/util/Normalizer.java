package org.example.util;

public class Normalizer {

    private Normalizer(){

    };

    public static String normalizePlate(String plate) {

        if (plate == null) {

            return null ;

        }
        return plate.trim().toUpperCase();
    }

    public static String normalizeOwner(String OwnerName) {

        if (OwnerName == null) {

            return null ;

        }
        return OwnerName.trim().toLowerCase();
    }
}

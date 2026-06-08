package org.example.util;

public class PlateNormalizer {

    private PlateNormalizer (){

    };

    public static String normalize(String plate) {

        if (plate == null) {

            return null ;

        }
        return plate.trim().toUpperCase();
    }
}

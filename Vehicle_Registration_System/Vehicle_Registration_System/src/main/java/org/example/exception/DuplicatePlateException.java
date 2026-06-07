package org.example.exception;

public class DuplicatePlateException extends RuntimeException{

    public DuplicatePlateException (){

        super("Already there is a vehicle register with this plateNumber");

    }
}

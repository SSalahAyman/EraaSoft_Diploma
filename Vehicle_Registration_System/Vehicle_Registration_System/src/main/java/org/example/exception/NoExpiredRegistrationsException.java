package org.example.exception;

public class NoExpiredRegistrationsException extends RuntimeException{

    public NoExpiredRegistrationsException (){

        super ("No expired registrations found. ");

    }
}

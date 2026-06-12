package org.example.exception;

public class MissingMandatoryFieldException extends RuntimeException{

    public MissingMandatoryFieldException () {

        super ("MissingMandatoryField !");

    }
}

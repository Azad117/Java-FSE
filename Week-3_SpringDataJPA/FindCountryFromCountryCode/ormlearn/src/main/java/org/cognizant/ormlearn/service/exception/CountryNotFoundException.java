package org.cognizant.ormlearn.service.exception;

public class CountryNotFoundException extends RuntimeException{

    public CountryNotFoundException() {
        super("Country not found");
    }

}

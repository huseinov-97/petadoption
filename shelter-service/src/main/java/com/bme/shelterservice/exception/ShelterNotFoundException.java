package com.bme.shelterservice.exception;

public class ShelterNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 12378432748937234L;

    public ShelterNotFoundException(Integer id){
        super("Shelter not found with id: {}" + id);
    }
}

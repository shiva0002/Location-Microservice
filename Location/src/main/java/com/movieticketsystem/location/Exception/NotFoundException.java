package com.movieticketsystem.location.Exception;

public class NotFoundException extends RuntimeException{
    
    public NotFoundException(String message){
        super(message);
    }
}
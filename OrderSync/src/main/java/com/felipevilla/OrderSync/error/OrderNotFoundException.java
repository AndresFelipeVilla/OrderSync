package com.felipevilla.OrderSync.error;

public class OrderNotFoundException extends Exception{

    public OrderNotFoundException(String message){
        super(message);  
    }
}

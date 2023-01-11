package com.demo.currancyconverter.exceptions;

public class CurrencyNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 6946610859941668007L;

	public CurrencyNotFoundException(String message){
        super(message);
    }
}

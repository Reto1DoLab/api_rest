package com.Reto1.Reto1.exception;

public class CinemasDoLabException extends RuntimeException {

    public CinemasDoLabException(String exMessage, Exception exception){
        super(exMessage, exception);
    }

    public CinemasDoLabException(String exMessage){
        super(exMessage);
    }
}

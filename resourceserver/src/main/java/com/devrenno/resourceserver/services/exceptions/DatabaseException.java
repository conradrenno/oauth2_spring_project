package com.devrenno.resourceserver.services.exceptions;

public class DatabaseException extends RuntimeException{

    public DatabaseException(String msg){
        super(msg);
    }
}

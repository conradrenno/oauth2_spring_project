package com.devrenno.resourceserver.services.exceptions;

public class ForbiddenException extends RuntimeException{

    public ForbiddenException(String msg){
        super(msg);
    }
}

package com.secondTry.ShouldWork.exceptions;

public class HumanAlreadyExistsException extends RuntimeException{
    private String message;

    public HumanAlreadyExistsException() {}

    public HumanAlreadyExistsException(String msg){
        super(msg);
        this.message=msg;
    }
}

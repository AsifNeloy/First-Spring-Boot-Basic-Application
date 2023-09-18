package com.secondTry.ShouldWork.exceptions;

public class NoSuchHumanexistsException extends RuntimeException{
    private String message;
    public NoSuchHumanexistsException(){}
    public NoSuchHumanexistsException(String msg){
        super(msg);
        this.message=msg;
    }
}

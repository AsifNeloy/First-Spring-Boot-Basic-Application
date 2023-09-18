package com.secondTry.ShouldWork.controllers;

import com.secondTry.ShouldWork.exceptions.ApplicationError;
import com.secondTry.ShouldWork.exceptions.HumanAlreadyExistsException;
import com.secondTry.ShouldWork.exceptions.NoSuchHumanexistsException;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

@ControllerAdvice
@RestController
public class Error  {

    @ExceptionHandler(NoSuchHumanexistsException.class)
    public ResponseEntity<ApplicationError> handleNoSuchHumanExistsException(NoSuchHumanexistsException exception, WebRequest webRequest){
        ApplicationError applicationError = new ApplicationError();
        applicationError.setCode(101);
        applicationError.setMessage("No human found with the details given!");
        return new ResponseEntity<>(applicationError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HumanAlreadyExistsException.class)
    public ResponseEntity<ApplicationError> handleHumanAlreadyExistsException(HumanAlreadyExistsException exception, WebRequest webRequest){
        ApplicationError error = new ApplicationError();
        error.setCode(102);
        error.setMessage("Human already exists!");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

}

package com.secondTry.ShouldWork.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApplicationError {
    public int code;
    public String message;

}

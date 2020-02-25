package com.example.demo.UserControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class UserExceptionHandler {


    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public String handleNoSuchElementException(NoSuchElementException exception){
        return exception.getMessage();
    }

    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public String handleNullPointerException(NullPointerException exception){
        return exception.getMessage();
    }

    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public String handleNumberFormatException(NumberFormatException exception){
        return exception.getMessage();
    }

}
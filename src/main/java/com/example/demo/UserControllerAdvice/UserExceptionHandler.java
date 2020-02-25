package com.example.demo.UserControllerAdvice;

import com.example.demo.model.ExceptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class UserExceptionHandler {
    @Autowired
    ExceptionModel exceptionModel;
    @ExceptionHandler
    public ResponseEntity<ExceptionModel> handleUserNotFoundException(UserNotFoundException exception) {
        exceptionModel.setMessage(exception.getMessage());
        exceptionModel.setStatus("404");
        return new ResponseEntity<ExceptionModel>(exceptionModel, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionModel> handleUserInvalidDataException(UserInvalidDataException exception) {
        exceptionModel.setMessage(exception.getMessage());
        exceptionModel.setStatus("400");
        return new ResponseEntity<ExceptionModel>(exceptionModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionModel> handleNumberFormatException(NumberFormatException exception){
        exceptionModel.setMessage("Number is expected as Input");
        exceptionModel.setStatus("400");
        return new ResponseEntity<ExceptionModel>(exceptionModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionModel> handleException(Exception exception){
        exceptionModel.setMessage("Internal server Erroe");
        exceptionModel.setStatus("500");
        return new ResponseEntity<ExceptionModel>(exceptionModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
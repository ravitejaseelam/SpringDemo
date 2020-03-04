package com.example.demo.handler;

import com.example.demo.exception.UserInvalidDataException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.ExceptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    public ExceptionModel getExceptionModel() {
        return exceptionModel;
    }

    public void setExceptionModel(ExceptionModel exceptionModel) {
        this.exceptionModel = exceptionModel;
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
        exceptionModel.setMessage("Internal server Error");
        exceptionModel.setStatus("500");
        return new ResponseEntity<ExceptionModel>(exceptionModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
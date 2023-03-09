package com.example.demo.studentmanagement.errors;

import com.example.demo.studentmanagement.dto.Error;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ControllerAdvice
public class ApiAdvice {
    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Error> notFoundException(NotFoundException e){
        Error error = new Error();
        error.setErrorCode(e.getErrorCode().value());
        error.setErrorMessage(e.getMessage());
        error.setErrorTime(new Date());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody Error badRequestException(BadRequestException e){
        Error error = new Error();
        error.setErrorMessage(e.getMessage());
        error.setErrorCode(e.getErrorCode().value());
        error.setErrorTime(new Date());
        return error;
    }
}

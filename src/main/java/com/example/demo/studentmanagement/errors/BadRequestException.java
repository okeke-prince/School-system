package com.example.demo.studentmanagement.errors;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatus;
@Getter
@Setter
@RequiredArgsConstructor
//@Builder
public class BadRequestException extends Exception{

    private HttpStatus errorCode;

    public BadRequestException(String message){
        super(message);
    }

    public BadRequestException(String message, HttpStatus errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}

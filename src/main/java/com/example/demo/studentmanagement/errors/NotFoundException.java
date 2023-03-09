package com.example.demo.studentmanagement.errors;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@RequiredArgsConstructor
//@Builder
public class NotFoundException extends Exception{

    private HttpStatus errorCode;

    public NotFoundException(String message){
        super(message);
    }

    public NotFoundException(String message, HttpStatus errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}

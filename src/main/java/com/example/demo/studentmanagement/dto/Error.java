package com.example.demo.studentmanagement.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
//@Builder
public class Error {
    private Integer errorCode;

    private String errorMessage;

    private Date errorTime;
}

package com.example.demo.studentmanagement.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor

public class LecturerRequestDto {
    private long id;

    private String name;

    private String course;
}

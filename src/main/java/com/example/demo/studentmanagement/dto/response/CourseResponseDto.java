package com.example.demo.studentmanagement.dto.response;

import com.example.demo.studentmanagement.entity.Lecturer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CourseResponseDto {
    private long course_id;
    private String name;
    private Lecturer lecturer;
}

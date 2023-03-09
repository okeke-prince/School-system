package com.example.demo.studentmanagement.dto.request;

import com.example.demo.studentmanagement.entity.Course;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class CourseRequestDto {
    private String name;

    private List<Course> courses;
}

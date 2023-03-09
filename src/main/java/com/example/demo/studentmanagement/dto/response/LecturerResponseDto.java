package com.example.demo.studentmanagement.dto.response;

import com.example.demo.studentmanagement.entity.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class LecturerResponseDto {
    private long id;

    private String name;

    private Course course;
}

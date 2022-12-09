package com.example.demo.studentmanagement.service;

import com.example.demo.studentmanagement.dto.request.StudentResponseDto;

import java.util.List;

public interface StudentService {
    StudentResponseDto createStudent(StudentResponseDto studentRequestDto);

    List<StudentResponseDto> getAllStudents();
}

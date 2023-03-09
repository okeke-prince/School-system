package com.example.demo.studentmanagement.service;

import com.example.demo.studentmanagement.dto.request.StudentRequestDto;
import com.example.demo.studentmanagement.dto.response.StudentResponseDto;
import com.example.demo.studentmanagement.errors.BadRequestException;
import com.example.demo.studentmanagement.errors.NotFoundException;

import java.util.List;

public interface StudentService {
    StudentResponseDto createStudent(StudentRequestDto studentRequestDto)throws BadRequestException;

    List<StudentResponseDto> getAllStudents()throws BadRequestException, NotFoundException;

    StudentResponseDto getStudent(long id)throws BadRequestException, NotFoundException;
}

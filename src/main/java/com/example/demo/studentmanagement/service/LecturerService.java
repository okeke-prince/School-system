package com.example.demo.studentmanagement.service;

import com.example.demo.studentmanagement.dto.request.LecturerRequestDto;
import com.example.demo.studentmanagement.dto.response.LecturerResponseDto;
import com.example.demo.studentmanagement.errors.NotFoundException;

public interface LecturerService {
    LecturerResponseDto newLecturer(LecturerRequestDto lecturerRequestDto) throws NotFoundException;
}

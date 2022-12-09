package com.example.demo.studentmanagement.service;

import com.example.demo.studentmanagement.dto.request.DepartmentRequestDto;
import com.example.demo.studentmanagement.dto.response.DepartmentResponseDto;

import java.util.List;

public interface DepartmentService {
    DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto);

    List<DepartmentResponseDto> getAllDepartments();
}

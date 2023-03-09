package com.example.demo.studentmanagement.service;

import com.example.demo.studentmanagement.dto.request.DepartmentRequestDto;
import com.example.demo.studentmanagement.dto.response.DepartmentResponseDto;
import com.example.demo.studentmanagement.dto.response.LecturerResponseDto;
import com.example.demo.studentmanagement.entity.Department;
import com.example.demo.studentmanagement.errors.NotFoundException;

import java.util.List;

public interface DepartmentService {
    DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto);

    List<DepartmentResponseDto> getAllDepartments() throws NotFoundException;

    Department getById(long id);

    DepartmentResponseDto addCourses(long id,long departmentId);

//    LecturerResponseDto assignLecturer(Long dptId, Long id);
}

package com.example.demo.studentmanagement.controller;

import com.example.demo.studentmanagement.dto.request.DepartmentRequestDto;
import com.example.demo.studentmanagement.dto.response.DepartmentResponseDto;
import com.example.demo.studentmanagement.dto.response.LecturerResponseDto;
import com.example.demo.studentmanagement.entity.Department;
import com.example.demo.studentmanagement.errors.BadRequestException;
import com.example.demo.studentmanagement.errors.NotFoundException;
import com.example.demo.studentmanagement.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    public DepartmentResponseDto createDepartment(@RequestBody DepartmentRequestDto departmentRequestDto){
        return departmentService.createDepartment(departmentRequestDto);
    }

    @PostMapping("/update/{departmentId}/{course_id}")
    public DepartmentResponseDto addCourses(@PathVariable(value = "course_id") long id,@PathVariable(value = "departmentId") long departmentId){
        return departmentService.addCourses(id,departmentId);
    }

    @GetMapping
    public List<DepartmentResponseDto> getAllDepartments() throws BadRequestException , NotFoundException {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable(value = "id") Long id) throws BadRequestException{
        return departmentService.getById(id);
    }

}

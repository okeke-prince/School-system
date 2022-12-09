package com.example.demo.studentmanagement.service.impl;

import com.example.demo.studentmanagement.dto.request.DepartmentRequestDto;
import com.example.demo.studentmanagement.dto.response.DepartmentResponseDto;
import com.example.demo.studentmanagement.entity.Department;
import com.example.demo.studentmanagement.repository.DepartmentRepository;
import com.example.demo.studentmanagement.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    @Override
    public DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto) {
        Department department = new Department();
        department.setName(departmentRequestDto.getName());
        department = departmentRepository.save(department);
        DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
        departmentResponseDto.setName(department.getName());
        departmentResponseDto.setId(department.getId());
        return departmentResponseDto;
    }

    @Override
    public List<DepartmentResponseDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentResponseDto> departmentResponseDto = new ArrayList<>();


        for (Department department : departments){
            DepartmentResponseDto depart = new DepartmentResponseDto();
            depart.setName(department.getName());
            depart.setId(department.getId());
            departmentResponseDto.add(depart);
        }

        return departmentResponseDto;
    }
}

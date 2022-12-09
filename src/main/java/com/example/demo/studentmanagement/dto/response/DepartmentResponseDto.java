package com.example.demo.studentmanagement.dto.response;

import com.example.demo.studentmanagement.entity.Department;
import com.example.demo.studentmanagement.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentResponseDto {

    private long id;

    private String name;

    public DepartmentResponseDto(String name) {

    }
}

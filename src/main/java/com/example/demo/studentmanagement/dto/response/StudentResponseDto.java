package com.example.demo.studentmanagement.dto.response;

import com.example.demo.studentmanagement.entity.Department;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {

    private long id;

    private String name;

    private int age;

    private String sex;

    private int matricNumber;

    private Department department;

}

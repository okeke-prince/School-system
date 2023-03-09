package com.example.demo.studentmanagement.dto.response;

import com.example.demo.studentmanagement.entity.Course;
import com.example.demo.studentmanagement.entity.Department;
import com.example.demo.studentmanagement.entity.Lecturer;
import com.example.demo.studentmanagement.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentResponseDto {

    private long id;

    private String name;

    private List<Course> courseList;

    public Lecturer lecturer;

}

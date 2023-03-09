package com.example.demo.studentmanagement.dto.request;

import com.example.demo.studentmanagement.entity.Course;
import com.example.demo.studentmanagement.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DepartmentRequestDto {

    @NotNull(message = "name is required")
    private String name;

    private long id;

    private List<Course> courseList;


}

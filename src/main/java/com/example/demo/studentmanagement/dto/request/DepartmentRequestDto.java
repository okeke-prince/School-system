package com.example.demo.studentmanagement.dto.request;

import com.example.demo.studentmanagement.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DepartmentRequestDto {

    @NotNull(message = "name is required")
    private String name;


}

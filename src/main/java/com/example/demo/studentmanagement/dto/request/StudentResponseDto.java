package com.example.demo.studentmanagement.dto.request;

import com.example.demo.studentmanagement.entity.Department;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {

    @NotNull(message = "name is required")
    private String name;

    @NotNull(message = "age is required")
    private int age;

    @NotNull(message = "sex is required")
    private String sex;

    @NotNull(message = "matric number is required")
    private int matricNumber;

    @NotNull(message = "department is required")
    private Department department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getMatricNumber() {
        return matricNumber;
    }

    public void setMatricNumber(int matricNumber) {
        this.matricNumber = matricNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

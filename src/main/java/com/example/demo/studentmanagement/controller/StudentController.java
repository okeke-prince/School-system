package com.example.demo.studentmanagement.controller;

import com.example.demo.studentmanagement.dto.request.StudentResponseDto;
import com.example.demo.studentmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/create-student")
    public StudentResponseDto createStudent(@RequestBody StudentResponseDto studentRequestDto){
        return studentService.createStudent(studentRequestDto);
    }

    @GetMapping("/all-students")
    public List<StudentResponseDto> getAllStudents(){
       return studentService.getAllStudents();
    }
}

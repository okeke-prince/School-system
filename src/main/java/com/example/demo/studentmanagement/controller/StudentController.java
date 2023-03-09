package com.example.demo.studentmanagement.controller;

import com.example.demo.studentmanagement.dto.request.StudentRequestDto;
import com.example.demo.studentmanagement.dto.response.StudentResponseDto;
import com.example.demo.studentmanagement.errors.BadRequestException;
import com.example.demo.studentmanagement.errors.NotFoundException;
import com.example.demo.studentmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/create")
    public StudentResponseDto createStudent(@RequestBody StudentRequestDto studentRequestDto) throws BadRequestException {
        return studentService.createStudent(studentRequestDto);
    }

    @GetMapping
    public List<StudentResponseDto> getAllStudents()throws BadRequestException, NotFoundException {
       return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponseDto getStudent(@PathVariable(value = "id") long id) throws BadRequestException, NotFoundException {
       return studentService.getStudent(id);
    }
}

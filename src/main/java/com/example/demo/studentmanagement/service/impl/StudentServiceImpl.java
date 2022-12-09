package com.example.demo.studentmanagement.service.impl;

import com.example.demo.studentmanagement.dto.request.StudentResponseDto;
import com.example.demo.studentmanagement.entity.Student;
import com.example.demo.studentmanagement.repository.StudentRepository;
import com.example.demo.studentmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    @Override
    public StudentResponseDto createStudent(StudentResponseDto studentRequestDto) {
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setSex(studentRequestDto.getSex());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMatricNumber(studentRequestDto.getMatricNumber());
        studentRepository.save(student);
        return studentRequestDto;
    }

    @Override
    public List<StudentResponseDto> getAllStudents() {

        List<Student> studentList = studentRepository.findAll();
        List<StudentResponseDto> studentRequestDtoList = new ArrayList<>();
        for (Student student : studentList){
            StudentResponseDto requestDto = new StudentResponseDto();
            requestDto.setName(student.getName());
            requestDto.setAge(student.getAge());
            requestDto.setDepartment(student.getDepartment());
            requestDto.setSex(student.getSex());
            requestDto.setMatricNumber(student.getMatricNumber());
            studentRequestDtoList.add(requestDto);
        }
        return studentRequestDtoList;
    }
}

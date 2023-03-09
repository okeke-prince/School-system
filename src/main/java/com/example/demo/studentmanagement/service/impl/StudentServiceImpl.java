package com.example.demo.studentmanagement.service.impl;

import com.example.demo.studentmanagement.dto.request.StudentRequestDto;
import com.example.demo.studentmanagement.dto.response.DepartmentResponseDto;
import com.example.demo.studentmanagement.dto.response.StudentResponseDto;
import com.example.demo.studentmanagement.entity.Department;
import com.example.demo.studentmanagement.entity.Student;
import com.example.demo.studentmanagement.errors.BadRequestException;
import com.example.demo.studentmanagement.errors.NotFoundException;
import com.example.demo.studentmanagement.repository.DepartmentRepository;
import com.example.demo.studentmanagement.repository.StudentRepository;
import com.example.demo.studentmanagement.service.DepartmentService;
import com.example.demo.studentmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;
    private final DepartmentService departmentService;
    @Override
    public StudentResponseDto createStudent(StudentRequestDto studentRequestDto) throws BadRequestException {
        Student student = new Student();
        Department department = departmentService.getById(studentRequestDto.getDepartmentId());
        student.setName(studentRequestDto.getName());
        student.setSex(studentRequestDto.getSex());
        student.setAge(studentRequestDto.getAge());
        student.setDepartment(department);
        student.setMatricNumber(studentRequestDto.getMatricNumber());
        studentRepository.save(student);

        DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
        departmentResponseDto.setId(department.getId());
        departmentResponseDto.setName(department.getName());

        StudentResponseDto newStudent = new StudentResponseDto();
        newStudent.setId(student.getId());
        newStudent.setMatricNumber(student.getMatricNumber());
        newStudent.setAge(student.getAge());
        newStudent.setDepartment(department);
        newStudent.setSex(student.getSex());
        newStudent.setName(student.getName());

        return newStudent;
    }

    @Override
    public List<StudentResponseDto> getAllStudents() throws BadRequestException, NotFoundException {

        List<Student> studentList = studentRepository.findAll();
        List<StudentResponseDto> studentRequestDtoList = new ArrayList<>();
        for (Student student : studentList){

            DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
            departmentResponseDto.setId(student.getDepartment().getId());


            StudentResponseDto requestDto = new StudentResponseDto();
            requestDto.setId(student.getId());
            requestDto.setName(student.getName());
            requestDto.setAge(student.getAge());
            requestDto.setDepartment(student.getDepartment());
            requestDto.setSex(student.getSex());
            requestDto.setMatricNumber(student.getMatricNumber());
            studentRequestDtoList.add(requestDto);
        }
        return studentRequestDtoList;
    }

    @Override
    public StudentResponseDto getStudent(long id) {

        StudentResponseDto studentResponseDto = new StudentResponseDto();

        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()){
            Student data = student.get();

            studentResponseDto.setId(data.getId());
            studentResponseDto.setName(data.getName());
            studentResponseDto.setAge(data.getAge());
            studentResponseDto.setSex(data.getSex());
            studentResponseDto.setMatricNumber(data.getMatricNumber());
            studentResponseDto.setDepartment(data.getDepartment());

            return studentResponseDto;
        }else{
            throw new RuntimeException();
        }
    }
}

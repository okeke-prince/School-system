package com.example.demo.studentmanagement.service.impl;

import com.example.demo.studentmanagement.dto.request.DepartmentRequestDto;
import com.example.demo.studentmanagement.dto.response.DepartmentResponseDto;
import com.example.demo.studentmanagement.dto.response.*;
import com.example.demo.studentmanagement.entity.Course;
import com.example.demo.studentmanagement.entity.Department;
import com.example.demo.studentmanagement.entity.Lecturer;
import com.example.demo.studentmanagement.errors.NotFoundException;
import com.example.demo.studentmanagement.repository.CourseRepository;
import com.example.demo.studentmanagement.repository.DepartmentRepository;
import com.example.demo.studentmanagement.repository.LecturerRepository;
import com.example.demo.studentmanagement.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final CourseRepository courseRepository;

    private final LecturerRepository lecturerRepository;

    @Override
    public DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto) {
        Department department = new Department();
        department.setName(departmentRequestDto.getName());
        department.setCourse(departmentRequestDto.getCourseList());
        departmentRepository.save(department);
        DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
        departmentResponseDto.setName(department.getName());
        departmentResponseDto.setCourseList(department.getCourse());
        departmentResponseDto.setId(department.getId());

        return departmentResponseDto;
    }

    @Override
    public List<DepartmentResponseDto> getAllDepartments()throws NotFoundException {

            List<Department> departments = departmentRepository.findAll();
            List<DepartmentResponseDto> departmentResponseDto = new ArrayList<>();
            for (Department department : departments){
                DepartmentResponseDto depart = new DepartmentResponseDto();
                depart.setName(department.getName());
                depart.setId(department.getId());
                departmentResponseDto.add(depart);
            }
            return departmentResponseDto;


    }

    @Override
    public Department getById(long id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if(optionalDepartment.isPresent()){
            return optionalDepartment.get();
        }
        throw new RuntimeException();
    }

    @Override
    public DepartmentResponseDto addCourses(long courseId, long departmentId) {
        Course course = courseRepository.findById(courseId).get();
        List<Course> courseList = departmentRepository.findById(departmentId).get().getCourse();
        Department department = departmentRepository.findById(departmentId).get();
        courseList.add(course);

        DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
        departmentResponseDto.setCourseList(courseList);
        departmentResponseDto.setName(department.getName());
        departmentResponseDto.setId(department.getId());
        return departmentResponseDto;
    }

//    @Override
//    public LecturerResponseDto assignLecturer(Long courseId, Long id) {
//        Lecturer lecturer = lecturerRepository.getReferenceById(id);
//        Course course = courseRepository.getReferenceById(courseId);
//        lecturer.setCourse(course);
//
//
//        LecturerResponseDto lecturerResponseDto = new LecturerResponseDto();
//        lecturerResponseDto.setCourse(lecturer.getCourse());
//        lecturerResponseDto.setName(lecturer.getName());
//        lecturerResponseDto.setId(lecturer.getId());
//
//
//        return lecturerResponseDto;
//    }
}

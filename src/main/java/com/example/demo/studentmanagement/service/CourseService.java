package com.example.demo.studentmanagement.service;

import com.example.demo.studentmanagement.dto.request.CourseRequestDto;
import com.example.demo.studentmanagement.dto.response.CourseResponseDto;
import com.example.demo.studentmanagement.entity.Course;

import java.util.List;

public interface CourseService {
    CourseResponseDto newCourse(CourseRequestDto courseRequestDto);

    CourseResponseDto assignLecturer(long courseId, long lecturerId);

    List<Course> allCourses();
}

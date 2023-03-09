package com.example.demo.studentmanagement.controller;

import com.example.demo.studentmanagement.dto.request.CourseRequestDto;
import com.example.demo.studentmanagement.dto.response.CourseResponseDto;
import com.example.demo.studentmanagement.entity.Course;
import com.example.demo.studentmanagement.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public CourseResponseDto newCourse(@RequestBody CourseRequestDto courseRequestDto){
        return courseService.newCourse(courseRequestDto);
    }

    @PatchMapping("/assign/{courseId}/{lecturerId}")
    public CourseResponseDto assignLecturer(
            @PathVariable(value = "courseId") long courseId,
            @PathVariable(value = "lecturerId") long lecturerId
    ){
        return courseService.assignLecturer(courseId,lecturerId);
    }

    @GetMapping
    public List<Course> allCourses(){
        return courseService.allCourses();
    }
}

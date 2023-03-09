package com.example.demo.studentmanagement.service.impl;

import com.example.demo.studentmanagement.dto.request.CourseRequestDto;
import com.example.demo.studentmanagement.dto.response.CourseResponseDto;
import com.example.demo.studentmanagement.entity.Course;
import com.example.demo.studentmanagement.entity.Lecturer;
import com.example.demo.studentmanagement.repository.CourseRepository;
import com.example.demo.studentmanagement.repository.LecturerRepository;
import com.example.demo.studentmanagement.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final LecturerRepository lecturerRepository;
    @Override
    public CourseResponseDto newCourse(CourseRequestDto courseRequestDto) {
        Course course = new Course();
        course.setName(courseRequestDto.getName());
        courseRepository.save(course);

        CourseResponseDto courseResponseDto = new CourseResponseDto();
        courseResponseDto.setCourse_id(course.getId());
        courseResponseDto.setName(course.getName());

        return courseResponseDto;
    }

    @Override
    public CourseResponseDto assignLecturer(long courseId, long lecturerId) {
//        if (lecturerRepository.existsById(lecturerId)){
//            lecturerRepository.
//        }
        Optional<Lecturer> lecturer = lecturerRepository.findById(lecturerId);
        Optional<Course> course = courseRepository.findById(courseId);
        CourseResponseDto courseResponseDto = new CourseResponseDto();
        if (course.isPresent() && lecturer.isPresent()){
            Course newCourse = course.get();
            Lecturer newLecturer = lecturer.get();
            newCourse.setLecturer(newLecturer);


            courseResponseDto.setName(newCourse.getName());
            courseResponseDto.setCourse_id(newCourse.getId());
            courseResponseDto.setLecturer(newCourse.getLecturer());

        }
        return courseResponseDto;
    }

    @Override
    public List<Course> allCourses() {
        return courseRepository.findAll();
    }
}

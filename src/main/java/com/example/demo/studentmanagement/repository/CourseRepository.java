package com.example.demo.studentmanagement.repository;

import com.example.demo.studentmanagement.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}

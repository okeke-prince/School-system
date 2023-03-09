package com.example.demo.studentmanagement.repository;

import com.example.demo.studentmanagement.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturer,Long> {
}

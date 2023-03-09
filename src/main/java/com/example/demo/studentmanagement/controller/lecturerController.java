package com.example.demo.studentmanagement.controller;

import com.example.demo.studentmanagement.dto.request.LecturerRequestDto;
import com.example.demo.studentmanagement.dto.response.LecturerResponseDto;
import com.example.demo.studentmanagement.errors.NotFoundException;
import com.example.demo.studentmanagement.repository.LecturerRepository;
import com.example.demo.studentmanagement.service.LecturerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
@RequiredArgsConstructor
@RequestMapping("/api/v1/lecturer")
@RestController
public class lecturerController {
    private final LecturerService lecturerService;

    @PostMapping("/new")
    public LecturerResponseDto newLecturer(@RequestBody LecturerRequestDto lecturerRequestDto) throws NotFoundException {
        return lecturerService.newLecturer(lecturerRequestDto);
    }
}

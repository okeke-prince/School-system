package com.example.demo.studentmanagement.service.impl;

import com.example.demo.studentmanagement.dto.request.LecturerRequestDto;
import com.example.demo.studentmanagement.dto.response.LecturerResponseDto;
import com.example.demo.studentmanagement.entity.Lecturer;
import com.example.demo.studentmanagement.repository.LecturerRepository;
import com.example.demo.studentmanagement.service.LecturerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class lecturerServiceImpl implements LecturerService {

    private final LecturerRepository lecturerRepository;
    @Override
    public LecturerResponseDto newLecturer(LecturerRequestDto lecturerRequestDto) {
        Lecturer lecturer = new Lecturer();
        lecturer.setName(lecturerRequestDto.getName());
        lecturerRepository.save(lecturer);
        log.info("lecturer created");
        log.info("lecturer saved");
        LecturerResponseDto responseDto = new LecturerResponseDto();
        responseDto.setId(lecturer.getId());
        responseDto.setName(lecturer.getName());
        return responseDto;
    }
}

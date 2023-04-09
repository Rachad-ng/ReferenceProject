package com.sqli.negra.referenceproject.service;

import com.sqli.negra.referenceproject.dto.StudentDto;

public interface StudentService {

    StudentDto add(StudentDto studentDto);

    StudentDto getById(Long id);

    StudentDto update(StudentDto studentDto, Long id);

    void delete(Long id);
}

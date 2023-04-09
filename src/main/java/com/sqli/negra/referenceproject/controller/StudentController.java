package com.sqli.negra.referenceproject.controller;

import com.sqli.negra.referenceproject.dto.StudentDto;
import com.sqli.negra.referenceproject.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDto> add(@Valid @RequestBody StudentDto studentDto){

        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.add(studentDto));

    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable Long id){

        return ResponseEntity.ok(studentService.getById(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> update(@Valid @RequestBody StudentDto studentDto, @PathVariable Long id){

        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.update(studentDto, id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){

        studentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}

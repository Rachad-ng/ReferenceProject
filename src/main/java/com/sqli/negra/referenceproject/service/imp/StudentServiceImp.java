package com.sqli.negra.referenceproject.service.imp;

import com.sqli.negra.referenceproject.dto.StudentDto;
import com.sqli.negra.referenceproject.exception.DataNotFoundException;
import com.sqli.negra.referenceproject.exception.DataStoreException;
import com.sqli.negra.referenceproject.exception.ExceptionMessageHandler;
import com.sqli.negra.referenceproject.mapper.StudentMapper;
import com.sqli.negra.referenceproject.model.Student;
import com.sqli.negra.referenceproject.repository.StudentRepository;
import com.sqli.negra.referenceproject.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class StudentServiceImp implements StudentService {

    private StudentMapper studentMapper;
    private StudentRepository studentRepository;
    private ExceptionMessageHandler exceptionMessageHandler;

    @Override
    public StudentDto add(StudentDto studentDto) {

        Student student = studentMapper.asStudent(studentDto);
        student.getNoteSet().stream().forEach(note -> note.setStudent(student));
        try {
            studentRepository.save(student);
        }catch (Exception e){
            throw new DataStoreException(exceptionMessageHandler.getDataStoreExceptionMessage());
        }

        return studentMapper.asStudentDto(student);
    }

    @Override
    public StudentDto getById(Long id) {

        Optional<Student> optionalStudent = studentRepository.findById(id);

        try {
            return studentMapper.asStudentDto(optionalStudent.orElseThrow());
        }catch (NoSuchElementException ex){
            throw new DataNotFoundException(exceptionMessageHandler.getDataNotFoundExceptionMessage());
        }

    }

    @Override
    public StudentDto update(StudentDto studentDto, Long id) {

        Student student = studentMapper.asStudent(studentDto);
        student.setId(id);

        try {
            return studentMapper.asStudentDto(studentRepository.save(student));
        }catch (Exception ex){
            throw new DataStoreException(exceptionMessageHandler.getDataStoreExceptionMessage());
        }

    }

    @Override
    public void delete(Long id) {

        try {
            studentRepository.deleteById(id);
        }catch (Exception ex){
            throw new DataStoreException(exceptionMessageHandler.getDataNotFoundExceptionMessage());
        }

    }


}

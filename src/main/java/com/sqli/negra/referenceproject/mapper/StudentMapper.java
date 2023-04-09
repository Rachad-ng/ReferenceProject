package com.sqli.negra.referenceproject.mapper;

import com.sqli.negra.referenceproject.dto.StudentDto;
import com.sqli.negra.referenceproject.model.Student;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL)
public interface StudentMapper {

    Student asStudent(StudentDto studentDto);

    StudentDto asStudentDto(Student student);

}

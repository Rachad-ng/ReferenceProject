package com.sqli.negra.referenceproject.repository;

import com.sqli.negra.referenceproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
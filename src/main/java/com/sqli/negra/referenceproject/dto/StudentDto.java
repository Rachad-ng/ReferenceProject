package com.sqli.negra.referenceproject.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link com.sqli.negra.referenceproject.model.Student} entity
 */
@Data
public class StudentDto implements Serializable {

    @NotNull(message = "Student's identity number required")
    private String identityNumber;

    @NotNull(message = "Student's age required")
    private Integer age;

    @NotNull(message = "Student's notes required")
    private Set<NoteDto> noteSet = new java.util.LinkedHashSet<>();

}
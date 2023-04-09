package com.sqli.negra.referenceproject.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sqli.negra.referenceproject.model.Note} entity
 */
@Data
public class NoteDto implements Serializable {

    @NotNull(message = "Model label required")
    private String module;

    @NotNull(message = "NotePerTwenty label required")
    private Double notePerTwenty;

}
package com.sqli.negra.referenceproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String module;
    private Double notePerTwenty;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
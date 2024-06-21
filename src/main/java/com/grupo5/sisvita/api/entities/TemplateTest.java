package com.grupo5.sisvita.api.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class TemplateTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String author;

    @OneToMany(mappedBy = "templateTest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alternative> alternatives = new ArrayList<>();

    @OneToMany(mappedBy = "templateTest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "templateTest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Classification> classifications = new ArrayList<>();
}

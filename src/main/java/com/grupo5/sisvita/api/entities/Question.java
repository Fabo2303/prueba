package com.grupo5.sisvita.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String statement;
    private String image;
    private boolean inverted;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "template_test_id")
    @JsonIgnoreProperties({"questions", "alternatives", "classifications"})
    private TemplateTest templateTest;
}

package com.grupo5.sisvita.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Alternative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private int score;
    private int invertedScore;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "template_test_id")
    @JsonIgnoreProperties({"questions", "alternatives", "classifications"})
    private TemplateTest templateTest;

}

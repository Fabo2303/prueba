package com.grupo5.sisvita.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.grupo5.sisvita.config.CustomDateDeserializer;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class ResolvedTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int result;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "template_test_id")
    private TemplateTest templateTest;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "classification_id")
    @JsonIgnoreProperties({"templateTest"})
    private Classification classification;
}

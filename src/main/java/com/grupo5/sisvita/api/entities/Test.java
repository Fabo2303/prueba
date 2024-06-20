package com.grupo5.sisvita.api.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.grupo5.sisvita.config.CustomDateDeserializer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTest;

    private Long idTipoTest;
    private Long idPaciente;
    private int resultado;
    private String interpretacion;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date fecha;
}

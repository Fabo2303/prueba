package com.grupo5.sisvita.api.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.grupo5.sisvita.config.CustomDateDeserializer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCita;

    private Long idPaciente;
    private Long idEspecialista;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date fecha;

    private String motivo;
    private String detalle;
    private String estado;
}

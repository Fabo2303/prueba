package com.grupo5.sisvita.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Clasificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClasificacion;
    private Long idTipoTest;
    private int minimo;
    private int maximo;
    private String interpretacion;
}

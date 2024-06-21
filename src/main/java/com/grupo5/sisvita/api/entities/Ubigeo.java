package com.grupo5.sisvita.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Ubigeo {
    @Id
    private String ubigeo;

    private String departamento;
    private String provincia;
    private String distrito;
    private double latitud;
    private double longitud;
}

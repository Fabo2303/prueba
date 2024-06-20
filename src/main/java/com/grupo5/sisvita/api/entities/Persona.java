package com.grupo5.sisvita.api.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.grupo5.sisvita.config.CustomDateDeserializer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class Persona {
    @Id
    private String documento;

    private String tipoDocumento;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date fechaNacimiento;


    private String sexo;
    private String telefono;
    private String ubigeo;

}

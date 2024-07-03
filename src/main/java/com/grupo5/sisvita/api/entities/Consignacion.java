package com.grupo5.sisvita.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.grupo5.sisvita.config.CustomDateDeserializer;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class Consignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date date;

    private String observation;
    private String fundament;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPaciente")
    private Patient paciente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idSpecialist")
    private Specialist specialist;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTestResolved")
    private ResolvedTest resolvedTest;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDiagnostic")
    private Diagnostic diagnostic;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTreatment")
    private Treatment treatment;
}

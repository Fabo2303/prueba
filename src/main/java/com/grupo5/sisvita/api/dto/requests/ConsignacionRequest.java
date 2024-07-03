package com.grupo5.sisvita.api.dto.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.grupo5.sisvita.config.CustomDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsignacionRequest {

    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date date;

    private String observation;
    private String fundament;
    private Long idPaciente;
    private Long idSpecialist;
    private Long idTestResolved;
    private Long idDiagnostic;
    private Long idTreatment;
}

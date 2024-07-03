package com.grupo5.sisvita.api.dto.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.grupo5.sisvita.config.CustomDateDeserializer;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class ResolvedTestRequest {
    private Long id;
    private Long templateTestId;
    private Long idPaciente;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date date;

    private List<AnswerRequest> answers;
}

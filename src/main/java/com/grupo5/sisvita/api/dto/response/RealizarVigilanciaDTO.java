package com.grupo5.sisvita.api.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.grupo5.sisvita.api.entities.Patient;
import com.grupo5.sisvita.api.entities.ResolvedTest;
import com.grupo5.sisvita.config.CustomDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RealizarVigilanciaDTO {
    private Long id;
    private int result;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date date;

    private Long templateTestId;
    private Long classificationId;
    private Patient patient;
    private List<AnswerDTO> answers;

    public static RealizarVigilanciaDTO fromEntity(ResolvedTest resolvedTest) {
        return new RealizarVigilanciaDTO(
                resolvedTest.getId(),
                resolvedTest.getResult(),
                resolvedTest.getDate(),
                resolvedTest.getTemplateTest().getId(),
                resolvedTest.getClassification().getId(),
                resolvedTest.getPaciente(),
                resolvedTest.getAnswers().stream().map(AnswerDTO::fromEntity).toList()
        );
    }

    public ResolvedTest toEntity() {
        ResolvedTest resolvedTest = new ResolvedTest();
        resolvedTest.setId(this.id);
        resolvedTest.setDate(this.date);
        return resolvedTest;
    }
}

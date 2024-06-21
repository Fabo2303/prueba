package com.grupo5.sisvita.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.grupo5.sisvita.api.entities.ResolvedTest;
import com.grupo5.sisvita.config.CustomDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ResolvedTestDTO {
    private Long id;
    private int result;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date date;

    private Long templateTestId;
    private Long classificationId;
    private List<AnswerDTO> answers;

    public static ResolvedTestDTO fromEntity(ResolvedTest resolvedTest) {
        return new ResolvedTestDTO(
                resolvedTest.getId(),
                resolvedTest.getResult(),
                resolvedTest.getDate(),
                resolvedTest.getTemplateTest().getId(),
                resolvedTest.getClassification().getId(),
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

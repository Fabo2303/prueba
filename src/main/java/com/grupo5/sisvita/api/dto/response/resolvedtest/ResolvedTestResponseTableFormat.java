package com.grupo5.sisvita.api.dto.response.resolvedtest;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.grupo5.sisvita.api.entities.ResolvedTest;
import com.grupo5.sisvita.config.CustomDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResolvedTestResponseTableFormat {
    private Long id;
    private String namePatient;
    private String lastNamePatient;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date date;

    private String nameTemplateTest;
    private String colorClassification;

    public static ResolvedTestResponseTableFormat fromEntity(ResolvedTest resolvedTest) {
        return ResolvedTestResponseTableFormat.builder()
                .id(resolvedTest.getId())
                .namePatient(resolvedTest.getPaciente().getUser().getPersona().getName())
                .lastNamePatient(resolvedTest.getPaciente().getUser().getPersona().getName())
                .date(resolvedTest.getDate())
                .nameTemplateTest(resolvedTest.getTemplateTest().getName())
                .colorClassification(resolvedTest.getClassification().getAnxietyColor().getColor())
                .build();
    }
}

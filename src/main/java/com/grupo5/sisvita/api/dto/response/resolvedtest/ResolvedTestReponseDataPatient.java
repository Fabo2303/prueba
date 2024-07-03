package com.grupo5.sisvita.api.dto.response.resolvedtest;

import com.grupo5.sisvita.api.dto.response.AnswerResponseDataPatient;
import com.grupo5.sisvita.api.entities.ResolvedTest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResolvedTestReponseDataPatient {
    private Long id;
    private Long idPatient;
    private String documentType;
    private String document;
    private String name;
    private String lastName;
    private String secondLastName;
    private String nameTemplateTest;
    private String colorClassification;
    private String interpretation;
    private int result;
    private List<AnswerResponseDataPatient> answers;

    public static ResolvedTestReponseDataPatient fromEntity(ResolvedTest resolvedTest) {
        return ResolvedTestReponseDataPatient.builder()
                .id(resolvedTest.getId())
                .idPatient(resolvedTest.getPaciente().getId())
                .documentType(resolvedTest.getPaciente().getUser().getPersona().getDocumentType())
                .document(resolvedTest.getPaciente().getUser().getPersona().getDocument())
                .name(resolvedTest.getPaciente().getUser().getPersona().getName())
                .lastName(resolvedTest.getPaciente().getUser().getPersona().getLastName())
                .secondLastName(resolvedTest.getPaciente().getUser().getPersona().getSecondLastName())
                .nameTemplateTest(resolvedTest.getTemplateTest().getName())
                .colorClassification(resolvedTest.getClassification().getAnxietyColor().getColor())
                .interpretation(resolvedTest.getClassification().getInterpretation())
                .result(resolvedTest.getResult())
                .answers(AnswerResponseDataPatient.fromEntityList(resolvedTest.getAnswers()))
                .build();
    }

}

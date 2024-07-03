package com.grupo5.sisvita.api.dto.response.templatetest;

import com.grupo5.sisvita.api.dto.response.alternatives.AlternativeResponse;
import com.grupo5.sisvita.api.dto.response.questions.QuestionResponse;
import com.grupo5.sisvita.api.entities.TemplateTest;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TemplateTestWithAlternativesAndQuestionsResponse {
    private Long id;
    private String name;
    private List<AlternativeResponse> alternatives;
    private List<QuestionResponse> questions;

    public static TemplateTestWithAlternativesAndQuestionsResponse fromEntity(TemplateTest templateTest) {
        return TemplateTestWithAlternativesAndQuestionsResponse.builder()
                .id(templateTest.getId())
                .name(templateTest.getName())
                .alternatives(AlternativeResponse.fromEntities(templateTest.getAlternatives()))
                .questions(QuestionResponse.fromEntities(templateTest.getQuestions()))
                .build();
    }
}

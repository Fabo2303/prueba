package com.grupo5.sisvita.api.dto.response.questions;

import com.grupo5.sisvita.api.entities.Question;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class QuestionResponse {
    private Long id;
    private String statement;

    public static QuestionResponse fromEntity(Question question) {
        return QuestionResponse.builder().id(question.getId())
                .statement(question.getStatement()).build();
    }

    public static List<QuestionResponse> fromEntities(List<Question> questions) {
        return questions.stream()
                .map(QuestionResponse::fromEntity)
                .collect(Collectors.toList());
    }
}

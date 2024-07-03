package com.grupo5.sisvita.api.dto.response;

import com.grupo5.sisvita.api.entities.Answer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerResponseDataPatient {
    private String statement;
    private String alternative;

    public static AnswerResponseDataPatient fromEntity(Answer answer) {
        return AnswerResponseDataPatient.builder()
                .statement(answer.getQuestion().getStatement())
                .alternative(answer.getAlternative().getDescription())
                .build();
    }

    public static List<AnswerResponseDataPatient> fromEntityList(List<Answer> answers) {
        return answers.stream()
                .map(AnswerResponseDataPatient::fromEntity)
                .collect(Collectors.toList());
    }
}

package com.grupo5.sisvita.api.dto;

import com.grupo5.sisvita.api.entities.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class AnswerDTO {
    private Long id;
    private Long idResolvedTest;
    private Long idQuestion;
    private Long idAlternative;

    public static AnswerDTO fromEntity(Answer answer) {
        return new AnswerDTO(
                answer.getId(),
                answer.getResolvedTest().getId(),
                answer.getQuestion().getId(),
                answer.getAlternative().getId()
        );
    }
}

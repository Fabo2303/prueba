package com.grupo5.sisvita.api.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerRequest {
    private Long idQuestion;
    private Long idAlternative;
    private boolean inverted;
    private int score;
    private int invertedScore;
}

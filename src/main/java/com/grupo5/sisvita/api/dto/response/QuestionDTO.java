package com.grupo5.sisvita.api.dto.response;

import com.grupo5.sisvita.api.entities.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
    private Long id;
    private String statement;
    private String image;
    private boolean inverted;
    private Long idTemplateTest;

    public static QuestionDTO fromEntity(Question question) {
        return new QuestionDTO(
                question.getId(),
                question.getStatement(),
                question.getImage(),
                question.isInverted(),
                question.getTemplateTest().getId()
        );
    }
}

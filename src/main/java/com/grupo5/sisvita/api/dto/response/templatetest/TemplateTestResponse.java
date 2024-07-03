package com.grupo5.sisvita.api.dto.response.templatetest;

import com.grupo5.sisvita.api.entities.TemplateTest;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TemplateTestResponse {
    private Long id;
    private String name;

    public static TemplateTestResponse fromEntity(TemplateTest templateTest) {
        return TemplateTestResponse.builder()
                .id(templateTest.getId())
                .name(templateTest.getName())
                .build();
    }
}

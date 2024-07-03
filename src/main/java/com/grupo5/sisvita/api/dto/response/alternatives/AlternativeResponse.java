package com.grupo5.sisvita.api.dto.response.alternatives;

import com.grupo5.sisvita.api.entities.Alternative;
import lombok.Builder;
import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class AlternativeResponse {
    private Long id;
    private String description;
    private int score;

    public static AlternativeResponse fromEntity(Alternative alternative) {
        return AlternativeResponse.builder()
                .id(alternative.getId())
                .description(alternative.getDescription())
                .score(alternative.getScore())
                .build();
    }

    public static List<AlternativeResponse> fromEntities(List<Alternative> alternatives) {
        return alternatives.stream()
                .map(AlternativeResponse::fromEntity)
                .collect(Collectors.toList());
    }
}

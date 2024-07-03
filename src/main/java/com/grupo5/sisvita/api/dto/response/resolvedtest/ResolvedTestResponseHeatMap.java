package com.grupo5.sisvita.api.dto.response.resolvedtest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResolvedTestResponseHeatMap {
    private Long id;
    private String ubigeo;
    private String departamento;
    private double latitud;
    private double longitud;
    private int intensity;
    private long ubigeoIntensityCount;
}


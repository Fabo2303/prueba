package com.grupo5.sisvita.api.dto.response.resolvedtest;

import lombok.Data;

@Data
public class ResolvedTestResponseHeatMapTotalIntensity extends ResolvedTestResponseHeatMap{
    private long totalIntensity;

    public ResolvedTestResponseHeatMapTotalIntensity(Long id, String ubigeo, String departamento, double latitud, double longitud, int intensity, long ubigeoIntensityCount, long totalIntensity) {
        super(id, ubigeo, departamento, latitud, longitud, intensity, ubigeoIntensityCount);
        this.totalIntensity = totalIntensity;
    }
}

package com.grupo5.sisvita.api.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UbigeoRequest {
    private String departamento;
    private String provincia;
    private String distrito;
}

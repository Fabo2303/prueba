package com.grupo5.sisvita.api.dto.requests;

import com.grupo5.sisvita.api.entities.Specialist;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecialistRequest {
    private String license;
    private String specialty;
    private UserRequest userRequest;

    public static Specialist toEntity(SpecialistRequest specialistRequest) {
        Specialist specialist = new Specialist();
        specialist.setLicense(specialistRequest.getLicense());
        specialist.setSpecialty(specialistRequest.getSpecialty());
        return specialist;
    }
}

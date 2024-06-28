package com.grupo5.sisvita.api.dto.response;

import com.grupo5.sisvita.api.entities.Specialist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecialistDTO {
    private Long id;
    private String license;
    private String specialty;
    private Long idUser;

    public static SpecialistDTO fromEntity(Specialist specialist) {
        SpecialistDTO dto = new SpecialistDTO();
        dto.setId(specialist.getId());
        dto.setLicense(specialist.getLicense());
        dto.setSpecialty(specialist.getSpecialty());
        dto.setIdUser(specialist.getUser().getId());
        return dto;
    }
}

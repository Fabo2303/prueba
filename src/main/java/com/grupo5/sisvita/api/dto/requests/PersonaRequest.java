package com.grupo5.sisvita.api.dto.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.grupo5.sisvita.api.entities.Persona;
import com.grupo5.sisvita.config.CustomDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaRequest {
    private String document;
    private String documentType;
    private String name;
    private String lastName;
    private String secondLastName;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date birthDate;

    private String sex;
    private String phone;
    private String email;
    private UbigeoRequest ubigeoRequest;

    public static Persona toEntity(PersonaRequest personaRequest) {
        Persona persona = new Persona();
        persona.setDocument(personaRequest.getDocument());
        persona.setDocumentType(personaRequest.getDocumentType());
        persona.setName(personaRequest.getName());
        persona.setLastName(personaRequest.getLastName());
        persona.setSecondLastName(personaRequest.getSecondLastName());
        persona.setBirthDate(personaRequest.getBirthDate());
        persona.setSex(personaRequest.getSex());
        persona.setPhone(personaRequest.getPhone());
        persona.setEmail(personaRequest.getEmail());
        return persona;
    }
}

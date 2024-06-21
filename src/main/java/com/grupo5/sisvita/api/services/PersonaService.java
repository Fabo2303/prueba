package com.grupo5.sisvita.api.services;

import com.grupo5.sisvita.api.dto.PersonaDTO;
import com.grupo5.sisvita.api.entities.Persona;
import com.grupo5.sisvita.api.entities.Ubigeo;
import com.grupo5.sisvita.api.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private UbigeoService ubigeoService;

    public Persona savePersona(Persona persona) {
        Ubigeo ubigeo = persona.getUbigeo();
        if (ubigeo != null) {
            ubigeo = ubigeoService.findByUbigeo(ubigeo.getUbigeo());
            persona.setUbigeo(ubigeo);
        }
        return personaRepository.save(persona);
    }

    public Persona findByDocument(String document) {
        return personaRepository.findByDocument(document).orElse(null);
    }

    public Iterable<Persona> findAll() {
        return personaRepository.findAll();
    }

    public List<PersonaDTO> findAllPersonas() {
        List<Persona> personas = personaRepository.findAll();
        return personas.stream()
                .map(PersonaDTO::fromEntity)
                .collect(Collectors.toList());
    }
}

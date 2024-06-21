package com.grupo5.sisvita.api.repositories;

import com.grupo5.sisvita.api.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Optional<Persona> findByDocument(String document);
}

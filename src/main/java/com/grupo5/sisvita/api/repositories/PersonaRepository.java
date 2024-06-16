package com.grupo5.sisvita.api.repositories;

import com.grupo5.sisvita.api.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, String> {
    Optional<Persona> findByDocumento(String documento);
    Optional<Persona> findByTipoDocumento(String tipoDocumento);
    Optional<Persona> findByNombre(String nombre);
    Optional<Persona> findByApellidoPaterno(String apellidoPaterno);
    Optional<Persona> findByApellidoMaterno(String apellidoMaterno);
    Optional<Persona> findByFechaNacimiento(Date fechaNacimiento);
    Optional<Persona> findBySexo(String sexo);
    Optional<Persona> findByTelefono(String telefono);
}

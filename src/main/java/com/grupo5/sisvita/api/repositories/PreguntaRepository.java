package com.grupo5.sisvita.api.repositories;

import com.grupo5.sisvita.api.entities.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
    Optional<Pregunta> findByIdPregunta(Long idPregunta);
    Optional<Pregunta> findByEnunciado(String enunciado);
    List<Pregunta> findByIdTipoTest(Long idTipoTest);
}

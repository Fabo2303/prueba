package com.grupo5.sisvita.api.repositories;

import com.grupo5.sisvita.api.entities.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    Optional<Respuesta> findByIdTestAndIdPregunta(Long idTest, Long idPregunta);
    List<Respuesta> findByIdTest(Long idTest);
}

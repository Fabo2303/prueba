package com.grupo5.sisvita.api.repositories;

import com.grupo5.sisvita.api.entities.Clasificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClasificacionRepository extends JpaRepository<Clasificacion, Long> {
    Optional<Clasificacion> findByIdClasificacion(Long idClasificacion);
    Optional<Clasificacion> findByIdTipoTest(Long idTipoTest);
}

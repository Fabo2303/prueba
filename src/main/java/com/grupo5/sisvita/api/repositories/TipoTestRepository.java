package com.grupo5.sisvita.api.repositories;

import com.grupo5.sisvita.api.entities.TipoTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoTestRepository extends JpaRepository<TipoTest, Long> {
    Optional<TipoTest> findByIdTipoTest(Long idTipoTest);
    Optional<TipoTest> findByNombre(String nombre);
    Optional<TipoTest> findByDescripcion(String descripcion);
    Optional<TipoTest> findByAutor(String autor);
}

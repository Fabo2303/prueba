package com.grupo5.sisvita.api.repositories;

import com.grupo5.sisvita.api.entities.TipoTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoTestRepository extends JpaRepository<TipoTest, Long> {
    Optional<TipoTestRepository> findByIdTipoTest(Long idTipoTest);
    Optional<TipoTestRepository> findByNombre(String nombre);
    Optional<TipoTestRepository> findByDescripcion(String descripcion);
    Optional<TipoTestRepository> findByAutor(String autor);
}

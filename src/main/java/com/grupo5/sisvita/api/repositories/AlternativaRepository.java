package com.grupo5.sisvita.api.repositories;

import com.grupo5.sisvita.api.entities.Alternativa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlternativaRepository extends JpaRepository<Alternativa, Long> {
    Optional<Alternativa> findByIdAlternativa(Long idAlternativa);
    List<Alternativa> findByIdTipoTest(Long idTipoTest);
}

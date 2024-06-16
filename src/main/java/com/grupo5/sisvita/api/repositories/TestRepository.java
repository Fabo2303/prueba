package com.grupo5.sisvita.api.repositories;


import com.grupo5.sisvita.api.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {
    List<Test> findByIdPaciente(Long idPaciente);
}

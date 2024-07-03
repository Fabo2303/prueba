package com.grupo5.sisvita.api.repositories;

import com.grupo5.sisvita.api.entities.Diagnostic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface DiagnosticRepository extends JpaRepository<Diagnostic, Long>{
}
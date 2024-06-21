package com.grupo5.sisvita.api.repositories;

import com.grupo5.sisvita.api.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}

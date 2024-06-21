package com.grupo5.sisvita.api.services;

import com.grupo5.sisvita.api.dto.PatientDTO;
import com.grupo5.sisvita.api.entities.Patient;
import com.grupo5.sisvita.api.entities.User;
import com.grupo5.sisvita.api.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private UserService userService;

    public Patient savePatient(Patient patient) {
        User user = patient.getUser();
        if (user != null) {
            user = userService.saveUser(user);
            patient.setUser(user);
        }
        return patientRepository.save(patient);
    }

    public Patient findById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Iterable<Patient> findAll() {
        return patientRepository.findAll();
    }

    public List<PatientDTO> findAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientDTO::fromEntity)
                .collect(Collectors.toList());
    }
}

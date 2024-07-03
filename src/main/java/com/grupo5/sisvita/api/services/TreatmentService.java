package com.grupo5.sisvita.api.services;

import com.grupo5.sisvita.api.entities.Treatment;
import com.grupo5.sisvita.api.repositories.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {
    @Autowired
    private TreatmentRepository treatmentRepository;

    public Treatment save(Treatment treatment) {
        return treatmentRepository.save(treatment);
    }

    public List<Treatment> findAll() {
        return treatmentRepository.findAll();
    }
}

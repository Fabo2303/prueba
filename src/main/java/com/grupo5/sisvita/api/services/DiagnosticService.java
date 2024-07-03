package com.grupo5.sisvita.api.services;

import com.grupo5.sisvita.api.entities.Diagnostic;
import com.grupo5.sisvita.api.repositories.DiagnosticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosticService {
    @Autowired
    private DiagnosticRepository diagnosticRepository;

    public Diagnostic save(Diagnostic diagnostic) {
        return diagnosticRepository.save(diagnostic);
    }

    public List<Diagnostic> findAll() {
        return diagnosticRepository.findAll();
    }
}

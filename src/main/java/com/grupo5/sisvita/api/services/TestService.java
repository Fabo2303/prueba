package com.grupo5.sisvita.api.services;

import com.grupo5.sisvita.api.entities.Test;
import com.grupo5.sisvita.api.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    public List<Test> findByIdPaciente(Long idPaciente) {
        return testRepository.findByIdPaciente(idPaciente);
    }

    public Test save(Test test) {
        return testRepository.save(test);
    }
}

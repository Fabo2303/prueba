package com.grupo5.sisvita.api.services;

import com.grupo5.sisvita.api.entities.Sex;
import com.grupo5.sisvita.api.repositories.SexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SexService {
    @Autowired
    private SexRepository sexRepository;

    public List<Sex> getAllSexes() {
        return sexRepository.findAll();
    }
}

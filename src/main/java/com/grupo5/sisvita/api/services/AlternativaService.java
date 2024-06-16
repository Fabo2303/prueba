package com.grupo5.sisvita.api.services;

import com.grupo5.sisvita.api.entities.Alternativa;
import com.grupo5.sisvita.api.repositories.AlternativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlternativaService {
    @Autowired
    private AlternativaRepository alternativaRepository;

    public Alternativa findByIdAlternativa(Long idAlternativa){
        return alternativaRepository.findByIdAlternativa(idAlternativa).orElse(null);
    }

    public List<Alternativa> findByIdTipoTest(Long idTipoTest){
        return alternativaRepository.findByIdTipoTest(idTipoTest);
    }
}

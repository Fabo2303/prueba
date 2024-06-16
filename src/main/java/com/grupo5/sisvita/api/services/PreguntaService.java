package com.grupo5.sisvita.api.services;

import com.grupo5.sisvita.api.entities.Pregunta;
import com.grupo5.sisvita.api.repositories.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaService {
    @Autowired
    private PreguntaRepository preguntaRepository;

    public Pregunta findByIdPregunta(Long idPregunta){
        return preguntaRepository.findByIdPregunta(idPregunta).orElse(null);
    }

    public Pregunta findByEnunciado(String enunciado){
        return preguntaRepository.findByEnunciado(enunciado).orElse(null);
    }

    public List<Pregunta> findByIdTipoTest(Long idTipoTest){
        return preguntaRepository.findByIdTipoTest(idTipoTest);
    }
}

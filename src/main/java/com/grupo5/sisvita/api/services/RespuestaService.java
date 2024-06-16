package com.grupo5.sisvita.api.services;

import com.grupo5.sisvita.api.entities.Respuesta;
import com.grupo5.sisvita.api.repositories.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestaService {
    @Autowired
    private RespuestaRepository respuestaRepository;

    public Respuesta save(Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }

    public List<Respuesta> findByIdTest(Long idTest) {
        return respuestaRepository.findByIdTest(idTest);
    }
}

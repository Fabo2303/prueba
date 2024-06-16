package com.grupo5.sisvita.api.services;

import com.grupo5.sisvita.api.repositories.TipoTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoTestService {
    @Autowired
    private TipoTestRepository tipoTestRepository;

    public TipoTestRepository findByIdTipoTest(Long idTipoTest){
        return tipoTestRepository.findByIdTipoTest(idTipoTest).orElse(null);
    }

    public TipoTestRepository findByNombre(String nombre){
        return tipoTestRepository.findByNombre(nombre).orElse(null);
    }
}

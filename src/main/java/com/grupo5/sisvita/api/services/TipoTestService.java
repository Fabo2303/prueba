package com.grupo5.sisvita.api.services;

import com.grupo5.sisvita.api.entities.TipoTest;
import com.grupo5.sisvita.api.repositories.TipoTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoTestService {
    @Autowired
    private TipoTestRepository tipoTestRepository;

    public TipoTest findByIdTipoTest(Long idTipoTest){
        return tipoTestRepository.findByIdTipoTest(idTipoTest).orElse(null);
    }

    public TipoTest findByNombre(String nombre){
        return tipoTestRepository.findByNombre(nombre).orElse(null);
    }

    public List<TipoTest> findAll(){
        return tipoTestRepository.findAll();
    }
}

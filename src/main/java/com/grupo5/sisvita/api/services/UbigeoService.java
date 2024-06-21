package com.grupo5.sisvita.api.services;

import com.grupo5.sisvita.api.entities.Ubigeo;
import com.grupo5.sisvita.api.repositories.UbigeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbigeoService {
    @Autowired
    private UbigeoRepository ubigeoRepository;

    public Ubigeo saveUbigeo(Ubigeo ubigeo) {
        return ubigeoRepository.save(ubigeo);
    }

    public Ubigeo findByUbigeo(String ubigeo) {
        return ubigeoRepository.findById(ubigeo).orElse(null);
    }

    public Iterable<Ubigeo> findAll() {
        return ubigeoRepository.findAll();
    }

    public List<String> findProvinciasByDepartamento(String departamento) {
        return ubigeoRepository.findProvinciasByDepartamento(departamento);
    }

    public List<String> findDistritosByDepartamentoAndProvincia(String departamento, String provincia) {
        return ubigeoRepository.findDistritosByDepartamentoAndProvincia(departamento, provincia);
    }

    public String findUbigeoByDepartamentoAndProvinciaAndDistrito(String departamento, String provincia, String distrito) {
        return ubigeoRepository.findUbigeoByDepartamentoAndProvinciaAndDistrito(departamento, provincia, distrito);
    }
}

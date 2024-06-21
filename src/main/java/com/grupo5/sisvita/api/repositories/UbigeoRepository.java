package com.grupo5.sisvita.api.repositories;

import com.grupo5.sisvita.api.entities.Ubigeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UbigeoRepository extends JpaRepository<Ubigeo, String> {
    @Query("SELECT DISTINCT u.provincia FROM Ubigeo u WHERE u.departamento = :departamento")
    List<String> findProvinciasByDepartamento(String departamento);

    @Query("SELECT DISTINCT u.distrito FROM Ubigeo u WHERE u.departamento = :departamento AND u.provincia = :provincia")
    List<String> findDistritosByDepartamentoAndProvincia(String departamento, String provincia);

    @Query("SELECT u.ubigeo FROM Ubigeo u WHERE u.departamento = :departamento AND u.provincia = :provincia AND u.distrito = :distrito")
    String findUbigeoByDepartamentoAndProvinciaAndDistrito(String departamento, String provincia, String distrito);
}

package com.grupo5.sisvita.api.repositories;

import com.grupo5.sisvita.api.entities.Ubigeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UbigeoRepository extends JpaRepository<Ubigeo, String> {
    @Query("SELECT DISTINCT u.provincia FROM Ubigeo u WHERE u.departamento = :departamento")
    List<String> findProvinciasByDepartamento(@Param("departamento") String departamento);

    @Query("SELECT DISTINCT u.distrito FROM Ubigeo u WHERE u.departamento = :departamento AND u.provincia = :provincia")
    List<String> findDistritosByDepartamentoAndProvincia(@Param("departamento") String departamento, @Param("provincia") String provincia);

    @Query("SELECT u.ubigeo FROM Ubigeo u WHERE u.departamento = :departamento AND u.provincia = :provincia AND u.distrito = :distrito")
    String findUbigeoByDepartamentoAndProvinciaAndDistrito(@Param("departamento") String departamento, @Param("provincia") String provincia,@Param("distrito") String distrito);
}

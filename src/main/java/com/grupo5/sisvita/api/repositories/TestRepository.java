package com.grupo5.sisvita.api.repositories;


import com.grupo5.sisvita.api.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {
    List<Test> findByIdPaciente(Long idPaciente);
    List<Test> findByIdTipoTest(Long idTipoTest);
    List<Test> findByFecha(Date fecha);
    List<Test> findByIdPacienteAndIdTipoTest(Long idPaciente, Long idTipoTest);
    List<Test> findByIdPacienteAndFecha(Long idPaciente, Date fecha);
    List<Test> findByIdTipoTestAndFecha(Long idTipoTest, Date fecha);
    List<Test> findByIdPacienteAndIdTipoTestAndFecha(Long idPaciente, Long idTipoTest, Date fecha);
}

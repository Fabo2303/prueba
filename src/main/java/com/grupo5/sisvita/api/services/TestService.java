package com.grupo5.sisvita.api.services;

import com.grupo5.sisvita.api.entities.Test;
import com.grupo5.sisvita.api.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    public List<Test> findByIdPaciente(Long idPaciente) {
        return testRepository.findByIdPaciente(idPaciente);
    }

    public List<Test> findByIdTipoTest(Long idTipoTest) {
        return testRepository.findByIdTipoTest(idTipoTest);
    }

    public List<Test> findByFecha(Date fecha) {
        return testRepository.findByFecha(fecha);
    }

    public List<Test> findByIdPacienteAndIdTipoTest(Long idPaciente, Long idTipoTest) {
        return testRepository.findByIdPacienteAndIdTipoTest(idPaciente, idTipoTest);
    }

    public List<Test> findByIdPacienteAndFecha(Long idPaciente, Date fecha) {
        return testRepository.findByIdPacienteAndFecha(idPaciente, fecha);
    }

    public List<Test> findByIdTipoTestAndFecha(Long idTipoTest, Date fecha) {
        return testRepository.findByIdTipoTestAndFecha(idTipoTest, fecha);
    }

    public List<Test> findByIdPacienteAndIdTipoTestAndFecha(Long idPaciente, Long idTipoTest, Date fecha) {
        return testRepository.findByIdPacienteAndIdTipoTestAndFecha(idPaciente, idTipoTest, fecha);
    }

    public List<Test> findAll() {
        return testRepository.findAll();
    }

    public void save(Test test) {
        testRepository.save(test);
    }
}

package com.grupo5.sisvita.api.repositories;

import com.grupo5.sisvita.api.entities.Consignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

public interface ConsignacionRepository extends JpaRepository<Consignacion, Long>{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO consignacion (date, observation, fundament, id_paciente, id_specialist, id_test_resolved, id_diagnostic, id_treatment) " +
            "VALUES (:date, :observation, :fundament, :idPaciente, :idSpecialist, :idTestResolved, :idDiagnostic, :idTreatment)", nativeQuery = true)
    void insertConsignacion(@Param("date") Date date,
                            @Param("observation") String observation,
                            @Param("fundament") String fundament,
                            @Param("idPaciente") Long idPaciente,
                            @Param("idSpecialist") Long idSpecialist,
                            @Param("idTestResolved") Long idTestResolved,
                            @Param("idDiagnostic") Long idDiagnostic,
                            @Param("idTreatment") Long idTreatment);

}

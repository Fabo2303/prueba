package com.grupo5.sisvita.api.repositories;

import com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseHeatMap;
import com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseTableFormat;
import com.grupo5.sisvita.api.entities.ResolvedTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

public interface ResolvedTestRepository extends JpaRepository<ResolvedTest, Long> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "INSERT INTO resolved_test (date, result, template_test_id, classification_id, id_paciente) VALUES (:date, :result, :templateTestId, :classificationId, :idPaciente)")
    void insert(@Param("date") Date date, @Param("result") int result, @Param("templateTestId") Long templateTestId, @Param("classificationId") Long classificationId, @Param("idPaciente") Long patientId);

    @Query(value = "SELECT * FROM resolved_test WHERE id_paciente = :idPaciente ORDER BY date DESC LIMIT 1", nativeQuery = true)
    ResolvedTest findTopByPacienteIdOrderByDateDesc(@Param("idPaciente") Long idPaciente);

    @Query("SELECT new com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseTableFormat(rt.id, rt.paciente.user.persona.name, rt.paciente.user.persona.lastName, rt.date, rt.templateTest.name, rt.classification.anxietyColor.color) " +
            "FROM ResolvedTest rt WHERE rt.templateTest.name = :name")
    List<ResolvedTestResponseTableFormat> findByTemplateTestName(@Param("name") String name);

    @Query("SELECT new com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseTableFormat(rt.id, rt.paciente.user.persona.name, rt.paciente.user.persona.lastName, rt.date, rt.templateTest.name, rt.classification.anxietyColor.color) " +
            "FROM ResolvedTest rt WHERE rt.classification.interpretation = :interpretation")
    List<ResolvedTestResponseTableFormat> findByClassificationInterpretation(@Param("interpretation") String interpretation);

    @Query("SELECT new com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseTableFormat(rt.id, rt.paciente.user.persona.name, rt.paciente.user.persona.lastName, rt.date, rt.templateTest.name, rt.classification.anxietyColor.color) " +
            "FROM ResolvedTest rt WHERE rt.templateTest.name = :name AND rt.classification.interpretation = :interpretation")
    List<ResolvedTestResponseTableFormat> findByTemplateTestNameAndClassificationInterpretation(@Param("name") String name, @Param("interpretation") String interpretation);

    @Query("SELECT new com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseTableFormat(rt.id, rt.paciente.user.persona.name, rt.paciente.user.persona.lastName, rt.date, rt.templateTest.name, rt.classification.anxietyColor.color) " +
            "FROM ResolvedTest rt WHERE rt.date BETWEEN :fechaInicio AND :fechaFin")
    List<ResolvedTestResponseTableFormat> findByDateBetween(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Query("SELECT new com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseTableFormat(rt.id, rt.paciente.user.persona.name, rt.paciente.user.persona.lastName, rt.date, rt.templateTest.name, rt.classification.anxietyColor.color) " +
            "FROM ResolvedTest rt WHERE rt.date BETWEEN :fechaInicio AND :fechaFin AND rt.templateTest.name = :name")
    List<ResolvedTestResponseTableFormat> findByDateBetweenAndTemplateTestName(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("name") String name);

    @Query("SELECT new com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseTableFormat(rt.id, rt.paciente.user.persona.name, rt.paciente.user.persona.lastName, rt.date, rt.templateTest.name, rt.classification.anxietyColor.color) " +
            "FROM ResolvedTest rt WHERE rt.date BETWEEN :fechaInicio AND :fechaFin AND rt.classification.interpretation = :interpretation")
    List<ResolvedTestResponseTableFormat> findByDateBetweenAndClassificationInterpretation(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("interpretation") String interpretation);

    @Query("SELECT new com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseTableFormat(rt.id, rt.paciente.user.persona.name, rt.paciente.user.persona.lastName, rt.date, rt.templateTest.name, rt.classification.anxietyColor.color) " +
            "FROM ResolvedTest rt WHERE rt.date BETWEEN :fechaInicio AND :fechaFin AND rt.templateTest.name = :name AND rt.classification.interpretation = :interpretation")
    List<ResolvedTestResponseTableFormat> findByDateBetweenAndTemplateTestNameAndClassificationInterpretation(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("name") String name, @Param("interpretation") String interpretation);

    @Query("SELECT new com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseTableFormat(rt.id, rt.paciente.user.persona.name, rt.paciente.user.persona.lastName, rt.date, rt.templateTest.name, rt.classification.anxietyColor.color) FROM ResolvedTest rt")
    List<ResolvedTestResponseTableFormat> findAllResolvedTestsResponse();

    @Query("SELECT new com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseHeatMap(" +
            "MIN(rt.id), rt.paciente.user.persona.ubigeo.ubigeo, rt.paciente.user.persona.ubigeo.departamento, " +
            "rt.paciente.user.persona.ubigeo.latitud, rt.paciente.user.persona.ubigeo.longitud, " +
            "rt.classification.intensity, COUNT(rt.id)) " +
            "FROM ResolvedTest rt " +
            "GROUP BY rt.paciente.user.persona.ubigeo.ubigeo, rt.paciente.user.persona.ubigeo.departamento, " +
            "rt.paciente.user.persona.ubigeo.latitud, rt.paciente.user.persona.ubigeo.longitud, rt.classification.intensity")
    List<ResolvedTestResponseHeatMap> findAllResolvedTestHeatMap();

    @Query("SELECT new com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseHeatMap(" +
            "MIN(rt.id), rt.paciente.user.persona.ubigeo.ubigeo, rt.paciente.user.persona.ubigeo.departamento, " +
            "rt.paciente.user.persona.ubigeo.latitud, rt.paciente.user.persona.ubigeo.longitud, " +
            "rt.classification.intensity, COUNT(rt.id)) " +
            "FROM ResolvedTest rt WHERE rt.date BETWEEN :fechaInicio AND :fechaFin " +
            "GROUP BY rt.paciente.user.persona.ubigeo.ubigeo, rt.paciente.user.persona.ubigeo.departamento, " +
            "rt.paciente.user.persona.ubigeo.latitud, rt.paciente.user.persona.ubigeo.longitud, rt.classification.intensity")
    List<ResolvedTestResponseHeatMap> findByDateBetweenHeatMap(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Query("SELECT new com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseHeatMap(" +
            "MIN(rt.id), rt.paciente.user.persona.ubigeo.ubigeo, rt.paciente.user.persona.ubigeo.departamento, " +
            "rt.paciente.user.persona.ubigeo.latitud, rt.paciente.user.persona.ubigeo.longitud, " +
            "rt.classification.intensity, COUNT(rt.id)) " +
            "FROM ResolvedTest rt WHERE rt.date BETWEEN :fechaInicio AND :fechaFin AND rt.templateTest.name = :name " +
            "GROUP BY rt.paciente.user.persona.ubigeo.ubigeo, rt.paciente.user.persona.ubigeo.departamento, " +
            "rt.paciente.user.persona.ubigeo.latitud, rt.paciente.user.persona.ubigeo.longitud, rt.classification.intensity")
    List<ResolvedTestResponseHeatMap> findByDateBetweenAndTemplateTestNameHeatMap(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("name") String name);

    @Query("SELECT new com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseHeatMap(" +
            "MIN(rt.id), rt.paciente.user.persona.ubigeo.ubigeo, rt.paciente.user.persona.ubigeo.departamento, " +
            "rt.paciente.user.persona.ubigeo.latitud, rt.paciente.user.persona.ubigeo.longitud, " +
            "rt.classification.intensity, COUNT(rt.id)) " +
            "FROM ResolvedTest rt WHERE rt.date BETWEEN :fechaInicio AND :fechaFin AND rt.classification.interpretation = :interpretation " +
            "GROUP BY rt.paciente.user.persona.ubigeo.ubigeo, rt.paciente.user.persona.ubigeo.departamento, " +
            "rt.paciente.user.persona.ubigeo.latitud, rt.paciente.user.persona.ubigeo.longitud, rt.classification.intensity")
    List<ResolvedTestResponseHeatMap> findByDateBetweenAndClassificationInterpretationHeatMap(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("interpretation") String interpretation);

    @Query("SELECT new com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseHeatMap(" +
            "MIN(rt.id), rt.paciente.user.persona.ubigeo.ubigeo, rt.paciente.user.persona.ubigeo.departamento, " +
            "rt.paciente.user.persona.ubigeo.latitud, rt.paciente.user.persona.ubigeo.longitud, " +
            "rt.classification.intensity, COUNT(rt.id)) " +
            "FROM ResolvedTest rt WHERE rt.date BETWEEN :fechaInicio AND :fechaFin AND rt.templateTest.name = :name AND rt.classification.interpretation = :interpretation " +
            "GROUP BY rt.paciente.user.persona.ubigeo.ubigeo, rt.paciente.user.persona.ubigeo.departamento, " +
            "rt.paciente.user.persona.ubigeo.latitud, rt.paciente.user.persona.ubigeo.longitud, rt.classification.intensity")
    List<ResolvedTestResponseHeatMap> findByDateBetweenAndTemplateTestNameAndClassificationInterpretationHeatMap(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("name") String name, @Param("interpretation") String interpretation);

    @Query("SELECT new com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseHeatMap(" +
            "MIN(rt.id), rt.paciente.user.persona.ubigeo.ubigeo, rt.paciente.user.persona.ubigeo.departamento, " +
            "rt.paciente.user.persona.ubigeo.latitud, rt.paciente.user.persona.ubigeo.longitud, " +
            "rt.classification.intensity, COUNT(rt.id)) " +
            "FROM ResolvedTest rt WHERE rt.templateTest.name = :name " +
            "GROUP BY rt.paciente.user.persona.ubigeo.ubigeo, rt.paciente.user.persona.ubigeo.departamento, " +
            "rt.paciente.user.persona.ubigeo.latitud, rt.paciente.user.persona.ubigeo.longitud, rt.classification.intensity")
    List<ResolvedTestResponseHeatMap> findByTemplateTestNameHeatMap(@Param("name") String name);

    @Query("SELECT new com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseHeatMap(" +
            "MIN(rt.id), rt.paciente.user.persona.ubigeo.ubigeo, rt.paciente.user.persona.ubigeo.departamento, " +
            "rt.paciente.user.persona.ubigeo.latitud, rt.paciente.user.persona.ubigeo.longitud, " +
            "rt.classification.intensity, COUNT(rt.id)) " +
            "FROM ResolvedTest rt WHERE rt.classification.interpretation = :interpretation " +
            "GROUP BY rt.paciente.user.persona.ubigeo.ubigeo, rt.paciente.user.persona.ubigeo.departamento, " +
            "rt.paciente.user.persona.ubigeo.latitud, rt.paciente.user.persona.ubigeo.longitud, rt.classification.intensity")
    List<ResolvedTestResponseHeatMap> findByClassificationInterpretationHeatMap(@Param("interpretation") String interpretation);

    @Query("SELECT new com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseHeatMap(" +
            "MIN(rt.id), rt.paciente.user.persona.ubigeo.ubigeo, rt.paciente.user.persona.ubigeo.departamento, " +
            "rt.paciente.user.persona.ubigeo.latitud, rt.paciente.user.persona.ubigeo.longitud, " +
            "rt.classification.intensity, COUNT(rt.id)) " +
            "FROM ResolvedTest rt WHERE rt.templateTest.name = :name AND rt.classification.interpretation = :interpretation " +
            "GROUP BY rt.paciente.user.persona.ubigeo.ubigeo, rt.paciente.user.persona.ubigeo.departamento, " +
            "rt.paciente.user.persona.ubigeo.latitud, rt.paciente.user.persona.ubigeo.longitud, rt.classification.intensity")
    List<ResolvedTestResponseHeatMap> findByTemplateTestNameAndClassificationInterpretationHeatMap(@Param("name") String name, @Param("interpretation") String interpretation);

}

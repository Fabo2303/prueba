package com.grupo5.sisvita.api.repositories;

import com.grupo5.sisvita.api.entities.Classification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClassificationRepository extends JpaRepository<Classification, Long> {
    @Query("SELECT c FROM Classification c WHERE c.templateTest.id = :templateTestId AND :result BETWEEN c.minimum AND c.maximum")
    Optional<Classification> findByTemplateTestIdAndResult(@Param("templateTestId") Long templateTestId, @Param("result") int result);

    @Query("SELECT c FROM Classification c WHERE c.templateTest.name = :templateTestName")
    List<Classification> findByTemplateTestName(@Param("templateTestName") String templateTestName);
}

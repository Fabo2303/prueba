package com.grupo5.sisvita.api.repositories;

import com.grupo5.sisvita.api.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "INSERT INTO answer (id_question, id_alternative, id_resolved_test) VALUES (:idQuestion, :idAlternative, :idResolvedTest)")
    void insert(@Param("idQuestion") Long idQuestion, @Param("idAlternative") Long idAlternative, @Param("idResolvedTest") Long idResolvedTest);
}

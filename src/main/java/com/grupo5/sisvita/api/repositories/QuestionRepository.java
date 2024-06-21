package com.grupo5.sisvita.api.repositories;

import com.grupo5.sisvita.api.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}

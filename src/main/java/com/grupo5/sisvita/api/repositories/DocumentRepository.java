package com.grupo5.sisvita.api.repositories;

import com.grupo5.sisvita.api.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, String>{
}

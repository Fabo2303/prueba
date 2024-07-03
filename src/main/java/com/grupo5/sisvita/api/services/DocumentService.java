package com.grupo5.sisvita.api.services;

import com.grupo5.sisvita.api.entities.Document;
import com.grupo5.sisvita.api.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }
}

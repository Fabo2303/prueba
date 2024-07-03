package com.grupo5.sisvita.api.controllers;

import com.grupo5.sisvita.api.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/document")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @GetMapping()
    public ResponseEntity<?> getAllDocuments() {
        return ResponseEntity.ok(documentService.getAllDocuments());
    }
}

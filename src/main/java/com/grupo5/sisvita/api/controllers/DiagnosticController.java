package com.grupo5.sisvita.api.controllers;

import com.grupo5.sisvita.api.entities.Diagnostic;
import com.grupo5.sisvita.api.services.DiagnosticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/diagnostic")
public class DiagnosticController {
    @Autowired
    private DiagnosticService diagnosticService;

    @PostMapping()
    public ResponseEntity<Diagnostic> save(@RequestBody Diagnostic diagnostic) {
        return ResponseEntity.ok(diagnosticService.save(diagnostic));
    }

    @GetMapping()
    public ResponseEntity<List<Diagnostic>> findAll() {
        return ResponseEntity.ok(diagnosticService.findAll());
    }
}

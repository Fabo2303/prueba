package com.grupo5.sisvita.api.controllers;

import com.grupo5.sisvita.api.entities.Treatment;
import com.grupo5.sisvita.api.services.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/treatment")
public class TreatmentController {
    @Autowired
    private TreatmentService treatmentService;

    @PostMapping()
    public ResponseEntity<Treatment> save(@RequestBody Treatment treatment) {
        return ResponseEntity.ok(treatmentService.save(treatment));
    }

    @GetMapping()
    public ResponseEntity<List<Treatment>> findAll() {
        return ResponseEntity.ok(treatmentService.findAll());
    }
}

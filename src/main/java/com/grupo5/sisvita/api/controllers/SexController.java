package com.grupo5.sisvita.api.controllers;

import com.grupo5.sisvita.api.services.SexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/sex")
public class SexController {
    @Autowired
    private SexService sexService;

    @GetMapping()
    public ResponseEntity<?> getAllSexes() {
        return ResponseEntity.ok(sexService.getAllSexes());
    }
}

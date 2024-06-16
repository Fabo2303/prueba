package com.grupo5.sisvita.api.controllers;

import com.grupo5.sisvita.api.services.AlternativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/alternativas")
public class AlternativaController {
    @Autowired
    private AlternativaService alternativaService;

    @GetMapping("/findByIdTipoTest/{idTipoTest}")
    public ResponseEntity<?> findByIdTipoTest(@PathVariable Long idTipoTest) {
        if (idTipoTest == null) {
            return ResponseEntity.badRequest().body("No se puede buscar una alternativa con un id de tipo test nulo");
        }
        return ResponseEntity.ok().body(alternativaService.findByIdTipoTest(idTipoTest));
    }
}

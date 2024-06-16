package com.grupo5.sisvita.api.controllers;

import com.grupo5.sisvita.api.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/preguntas")
public class PreguntaController {
    @Autowired
    private PreguntaService preguntaService;

    @GetMapping("/findByIdPregunta/{idPregunta}")
    public ResponseEntity<?> findByIdPregunta(@PathVariable Long idPregunta) {
        if (idPregunta == null) {
            return ResponseEntity.badRequest().body("No se puede buscar una pregunta con un id nulo");
        }
        return ResponseEntity.ok().body(preguntaService.findByIdPregunta(idPregunta));
    }

    @GetMapping("/findByEnunciado/{enunciado}")
    public ResponseEntity<?> findByEnunciado(@PathVariable String enunciado) {
        if (enunciado == null) {
            return ResponseEntity.badRequest().body("No se puede buscar una pregunta con un enunciado nulo");
        }
        return ResponseEntity.ok().body(preguntaService.findByEnunciado(enunciado));
    }

    @GetMapping("/findByIdTipoTest/{idTipoTest}")
    public ResponseEntity<?> findByIdTipoTest(@PathVariable Long idTipoTest) {
        if (idTipoTest == null) {
            return ResponseEntity.badRequest().body("No se puede buscar una pregunta con un id de tipo test nulo");
        }
        return ResponseEntity.ok().body(preguntaService.findByIdTipoTest(idTipoTest));
    }

    @GetMapping("/findAll")
    public String findAll() {
        return "Lista de preguntas";
    }
}

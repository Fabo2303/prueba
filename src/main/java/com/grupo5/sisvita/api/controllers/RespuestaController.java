package com.grupo5.sisvita.api.controllers;

import com.grupo5.sisvita.api.entities.Respuesta;
import com.grupo5.sisvita.api.services.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/respuestas")
public class RespuestaController {
    @Autowired
    private RespuestaService respuestaService;

    @GetMapping("/findByIdTest/{idTest}")
    public ResponseEntity<?> findByIdTest(@PathVariable Long idTest) {
        if (idTest == null) {
            return ResponseEntity.badRequest().body("No se puede buscar una respuesta con un id de test nulo");
        }
        return ResponseEntity.ok().body(respuestaService.findByIdTest(idTest));
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody List<Respuesta> respuestas) {
        if (respuestas == null) {
            return ResponseEntity.badRequest().body("No se puede guardar una respuesta nula");
        }
        respuestas.forEach(respuesta -> {
            if (respuesta == null) {
                ResponseEntity.badRequest().body("No se puede guardar una respuesta nula");
            }
        });
        respuestas.forEach(respuestaService::save);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Respuestas guardadas con éxito");
        return ResponseEntity.ok().body(response);
    }
}

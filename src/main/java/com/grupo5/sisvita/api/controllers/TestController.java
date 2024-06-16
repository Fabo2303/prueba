package com.grupo5.sisvita.api.controllers;

import com.grupo5.sisvita.api.entities.Test;
import com.grupo5.sisvita.api.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/tests")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/findByIdPaciente/{idPaciente}")
    public ResponseEntity<?> findByIdPaciente(@PathVariable Long idPaciente) {
        if (idPaciente == null) {
            return ResponseEntity.badRequest().body("No se puede buscar un test con un id de paciente nulo");
        }
        return ResponseEntity.ok().body(testService.findByIdPaciente(idPaciente));
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Test test) {
        if (test == null) {
            return ResponseEntity.badRequest().body("No se puede guardar un test nulo");
        }
        testService.save(test);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Test guardado con éxito");
        return ResponseEntity.ok().body(response);
    }

}

package com.grupo5.sisvita.api.controllers;

import com.grupo5.sisvita.api.entities.Test;
import com.grupo5.sisvita.api.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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

    @GetMapping("/findByIdTipoTest/{idTipoTest}")
    public ResponseEntity<?> findByIdTipoTest(@PathVariable Long idTipoTest) {
        if (idTipoTest == null) {
            return ResponseEntity.badRequest().body("No se puede buscar un test con un id de tipo de test nulo");
        }
        return ResponseEntity.ok().body(testService.findByIdTipoTest(idTipoTest));
    }

    @GetMapping("/findByFecha/{fecha}")
    public ResponseEntity<?> findByFecha(@PathVariable Date fecha) {
        if (fecha == null) {
            return ResponseEntity.badRequest().body("No se puede buscar un test con una fecha nula");
        }
        return ResponseEntity.ok().body(testService.findByFecha(fecha));
    }

    // RequestParam
    @GetMapping("/findByIdPacienteAndIdTipoTest")
    public ResponseEntity<?> findByIdPacienteAndIdTipoTest(@RequestParam Long idPaciente, @RequestParam Long idTipoTest) {
        if (idPaciente == null || idTipoTest == null) {
            return ResponseEntity.badRequest().body("No se puede buscar un test con un id de paciente o id de tipo de test nulo");
        }
        return ResponseEntity.ok().body(testService.findByIdPacienteAndIdTipoTest(idPaciente, idTipoTest));
    }

    @GetMapping("/findByIdPacienteAndFecha")
    public ResponseEntity<?> findByIdPacienteAndFecha(@RequestParam Long idPaciente, @RequestParam Date fecha) {
        if (idPaciente == null || fecha == null) {
            return ResponseEntity.badRequest().body("No se puede buscar un test con un id de paciente o fecha nulo");
        }
        return ResponseEntity.ok().body(testService.findByIdPacienteAndFecha(idPaciente, fecha));
    }

    @GetMapping("/findByIdTipoTestAndFecha")
    public ResponseEntity<?> findByIdTipoTestAndFecha(@RequestParam Long idTipoTest, @RequestParam Date fecha) {
        if (idTipoTest == null || fecha == null) {
            return ResponseEntity.badRequest().body("No se puede buscar un test con un id de tipo de test o fecha nulo");
        }
        return ResponseEntity.ok().body(testService.findByIdTipoTestAndFecha(idTipoTest, fecha));
    }

    @GetMapping("/findByIdPacienteAndIdTipoTestAndFecha")
    public ResponseEntity<?> findByIdPacienteAndIdTipoTestAndFecha(@RequestParam Long idPaciente, @RequestParam Long idTipoTest, @RequestParam Date fecha) {
        if (idPaciente == null || idTipoTest == null || fecha == null) {
            return ResponseEntity.badRequest().body("No se puede buscar un test con un id de paciente, id de tipo de test o fecha nulo");
        }
        return ResponseEntity.ok().body(testService.findByIdPacienteAndIdTipoTestAndFecha(idPaciente, idTipoTest, fecha));
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

package com.grupo5.sisvita.api.controllers;

import com.grupo5.sisvita.api.entities.Ubigeo;
import com.grupo5.sisvita.api.services.UbigeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/ubigeo")
public class UbigeoController {
    @Autowired
    private UbigeoService ubigeoService;

    @PostMapping()
    public ResponseEntity<Ubigeo> createUbigeo(@RequestBody Ubigeo ubigeo) {
        Ubigeo savedUbigeo = ubigeoService.saveUbigeo(ubigeo);
        return ResponseEntity.ok(savedUbigeo);
    }

    @GetMapping("/{ubigeo}")
    public ResponseEntity<Ubigeo> getUbigeoByUbigeo(@PathVariable String ubigeo) {
        Ubigeo ubigeoEntity = ubigeoService.findByUbigeo(ubigeo);
        return ResponseEntity.ok(ubigeoEntity);
    }

    @GetMapping()
    public ResponseEntity<Iterable<Ubigeo>> getAllUbigeos() {
        Iterable<Ubigeo> ubigeos = ubigeoService.findAll();
        return ResponseEntity.ok(ubigeos);
    }

    @GetMapping("/departamentos")
    public ResponseEntity<?> getDepartamentos() {
        List<String> departamentos = ubigeoService.findAllDepartamentos();
        Map<String, List<String>> response = Map.of("departamentos", departamentos);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/provincias")
    public ResponseEntity<?> getProvinciasByDepartamento(@RequestParam String departamento) {
        List<String> provincias = ubigeoService.findProvinciasByDepartamento(departamento);
        Map<String, List<String>> response = Map.of("provincias", provincias);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/distritos")
    public ResponseEntity<?> getDistritosByDepartamentoAndProvincia(@RequestParam String departamento, @RequestParam String provincia) {
        List<String> distritos = ubigeoService.findDistritosByDepartamentoAndProvincia(departamento, provincia);
        Map<String, List<String>> response = Map.of("distritos", distritos);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/ubigeo")
    public ResponseEntity<?> getUbigeoByDepartamentoAndProvinciaAndDistrito(@RequestParam String departamento, @RequestParam String provincia, @RequestParam String distrito) {
        String ubigeo = ubigeoService.findUbigeoByDepartamentoAndProvinciaAndDistrito(departamento, provincia, distrito);
        Map<String, String> response = Map.of("ubigeo", ubigeo);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/ubigeo-object")
    public ResponseEntity<?> getUbigeoByDepartamentoAndProvinciaAndDistritoObject(@RequestParam String departamento, @RequestParam String provincia, @RequestParam String distrito) {
        Ubigeo ubigeo = ubigeoService.findUbigeoByDepartamentoAndProvinciaAndDistritoObject(departamento, provincia, distrito);
        Map<String, Ubigeo> response = Map.of("ubigeo", ubigeo);
        return ResponseEntity.ok(response);
    }
}

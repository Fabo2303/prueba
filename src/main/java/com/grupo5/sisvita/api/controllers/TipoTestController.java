package com.grupo5.sisvita.api.controllers;

import com.grupo5.sisvita.api.services.TipoTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/tiposTests")
public class TipoTestController {
    @Autowired
    private TipoTestService tipoTestService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(tipoTestService.findAll());
    }
}

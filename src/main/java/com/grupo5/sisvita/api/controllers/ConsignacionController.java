package com.grupo5.sisvita.api.controllers;

import com.grupo5.sisvita.api.dto.requests.ConsignacionRequest;
import com.grupo5.sisvita.api.entities.Consignacion;
import com.grupo5.sisvita.api.services.ConsignacionService;
import com.grupo5.sisvita.api.services.ResolvedTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/consignacion")
public class ConsignacionController {
    @Autowired
    private ConsignacionService consignacionService;

    @Autowired
    private ResolvedTestService resolvedTestService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Consignacion consignacion, @RequestParam Long idtest) {
        return ResponseEntity.ok("Consignacion guardada");
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insert(@RequestBody ConsignacionRequest consignacionRequest) {
        consignacionService.insert(consignacionRequest);
        return ResponseEntity.ok("Consignacion guardada");
    }
}

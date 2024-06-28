package com.grupo5.sisvita.api.controllers;

import com.grupo5.sisvita.api.entities.Consignacion;
import com.grupo5.sisvita.api.entities.ResolvedTest;
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
        Consignacion consignacionSaved = consignacionService.save(consignacion);
        ResolvedTest resolvedTest = resolvedTestService.findById(idtest);
        resolvedTest.setConsignacion(consignacionSaved);
        resolvedTestService.saveResolvedTest(resolvedTest);
        return ResponseEntity.ok("Consignacion guardada con éxito");
    }
}

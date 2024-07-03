package com.grupo5.sisvita.api.controllers;

import com.grupo5.sisvita.api.dto.requests.ResolvedTestRequest;
import com.grupo5.sisvita.api.dto.response.RealizarVigilanciaDTO;
import com.grupo5.sisvita.api.dto.response.ResolvedTestDTO;
import com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestReponseDataPatient;
import com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseHeatMap;
import com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseHeatMapTotalIntensity;
import com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseTableFormat;
import com.grupo5.sisvita.api.entities.*;
import com.grupo5.sisvita.api.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/resolved-test")
public class ResolvedTestController {

    @Autowired
    private ResolvedTestService resolvedTestService;

    @PostMapping("/request")
    public ResponseEntity<?> createResolvedTest(@RequestBody ResolvedTestRequest resolvedTestRequest) {
        Map<String, ?> message = resolvedTestService.saveResolvedTest(resolvedTestRequest);
        return ResponseEntity.ok(message);
    }

    @GetMapping()
    public ResponseEntity<Iterable<ResolvedTest>> findAll() {
        Iterable<ResolvedTest> resolvedTests = resolvedTestService.findAll();
        return ResponseEntity.ok(resolvedTests);
    }

    @GetMapping("/response")
    public ResponseEntity<?> getAllResolvedTestsResponses() {
        List<ResolvedTestResponseTableFormat> resolvedTestsResponse = resolvedTestService.findAllResolvedTestResponse();
        return ResponseEntity.ok(resolvedTestsResponse);
    }

    @GetMapping("/dto")
    public ResponseEntity<Iterable<ResolvedTestDTO>> getAllResolvedTests() {
        Iterable<ResolvedTestDTO> resolvedTests = resolvedTestService.findAllResolvedTests();
        return ResponseEntity.ok(resolvedTests);
    }

    @GetMapping("/realizar-vigilancia")
    public ResponseEntity<Iterable<RealizarVigilanciaDTO>> realizarVigilancia() {
        Iterable<RealizarVigilanciaDTO> resolvedTests = resolvedTestService.realizarVigilancia();
        return ResponseEntity.ok(resolvedTests);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ResolvedTest> findById(@PathVariable Long id) {
        ResolvedTest resolvedTest = resolvedTestService.findById(id);
        return ResponseEntity.ok().body(resolvedTest);
    }

    @GetMapping("/findById/dto/{id}")
    public ResponseEntity<ResolvedTestReponseDataPatient> findByPatientId(@PathVariable Long id) {
        ResolvedTestReponseDataPatient resolvedTestReponseDataPatient = resolvedTestService.findByIdAndReturnDataPatient(id);
        return ResponseEntity.ok().body(resolvedTestReponseDataPatient);
    }

    @GetMapping("/findByTemplateTestName")
    public ResponseEntity<List<ResolvedTestResponseTableFormat>> findByTemplateTestName(@RequestParam String name) {
        List<ResolvedTestResponseTableFormat> resolvedTests = resolvedTestService.findByTemplateTestName(name);
        return ResponseEntity.ok().body(resolvedTests);
    }

    @GetMapping("/findByClassificationInterpretation")
    public ResponseEntity<List<ResolvedTestResponseTableFormat>> findByClassificationInterpretation(@RequestParam String interpretation) {
        List<ResolvedTestResponseTableFormat> resolvedTests = resolvedTestService.findByClassificationInterpretation(interpretation);
        return ResponseEntity.ok().body(resolvedTests);
    }

    @GetMapping("/findByTemplateTestNameAndClassificationInterpretation")
    public ResponseEntity<List<ResolvedTestResponseTableFormat>> findByTemplateTestNameAndClassificationInterpretation(@RequestParam String name, @RequestParam String interpretation) {
        List<ResolvedTestResponseTableFormat> resolvedTests = resolvedTestService.findByTemplateTestNameAndClassificationInterpretation(name, interpretation);
        return ResponseEntity.ok().body(resolvedTests);
    }

    @GetMapping("/findByDateBetween")
    public ResponseEntity<List<ResolvedTestResponseTableFormat>> findByDateBetween(@RequestParam Date fechaInicio, @RequestParam Date fechaFin) {
        List<ResolvedTestResponseTableFormat> resolvedTests = resolvedTestService.findByDateBetween(fechaInicio, fechaFin);
        return ResponseEntity.ok().body(resolvedTests);
    }

    @GetMapping("/findByDateBetweenAndTemplateTestName")
    public ResponseEntity<List<ResolvedTestResponseTableFormat>> findByDateBetweenAndTemplateTestName(@RequestParam Date fechaInicio, @RequestParam Date fechaFin, @RequestParam String name) {
        List<ResolvedTestResponseTableFormat> resolvedTests = resolvedTestService.findByDateBetweenAndTemplateTestName(fechaInicio, fechaFin, name);
        return ResponseEntity.ok().body(resolvedTests);
    }

    @GetMapping("/findByDateBetweenAndClassificationInterpretation")
    public ResponseEntity<List<ResolvedTestResponseTableFormat>> findByDateBetweenAndClassificationInterpretation(@RequestParam Date fechaInicio, @RequestParam Date fechaFin, @RequestParam String interpretation) {
        List<ResolvedTestResponseTableFormat> resolvedTests = resolvedTestService.findByDateBetweenAndClassificationInterpretation(fechaInicio, fechaFin, interpretation);
        return ResponseEntity.ok().body(resolvedTests);
    }

    @GetMapping("/findByDateBetweenAndTemplateTestNameAndClassificationInterpretation")
    public ResponseEntity<List<ResolvedTestResponseTableFormat>> findByDateBetweenAndTemplateTestNameAndClassificationInterpretation(@RequestParam Date fechaInicio, @RequestParam Date fechaFin, @RequestParam String name, @RequestParam String interpretation) {
        List<ResolvedTestResponseTableFormat> resolvedTests = resolvedTestService.findByDateBetweenAndTemplateTestNameAndClassificationInterpretation(fechaInicio, fechaFin, name, interpretation);
        return ResponseEntity.ok().body(resolvedTests);
    }

    @GetMapping("/heat-map")
    public ResponseEntity<?> getHeatMap() {
        List<ResolvedTestResponseHeatMap> heatMap = resolvedTestService.findAllHeatMap();
        List<ResolvedTestResponseHeatMapTotalIntensity> heatMapTotalIntensity = heatMap.stream().map(
                resolvedTestResponseHeatMap -> resolvedTestService.fromResolvedTestResponseHeatMap(resolvedTestResponseHeatMap)
        ).toList();
        return ResponseEntity.ok(heatMapTotalIntensity);
    }

    @GetMapping("/findByTemplateTestNameHeatMap")
    public ResponseEntity<?> findByTemplateTestNameHeatMap(@RequestParam String name) {
        List<ResolvedTestResponseHeatMap> heatMap = resolvedTestService.findByTemplateTestNameHeatMap(name);
        List<ResolvedTestResponseHeatMapTotalIntensity> heatMapTotalIntensity = heatMap.stream().map(
                resolvedTestResponseHeatMap -> resolvedTestService.fromResolvedTestResponseHeatMap(resolvedTestResponseHeatMap)
        ).toList();
        return ResponseEntity.ok(heatMapTotalIntensity);
    }

    @GetMapping("/findByClassificationInterpretationHeatMap")
    public ResponseEntity<?> findByClassificationInterpretationHeatMap(@RequestParam String interpretation) {
        List<ResolvedTestResponseHeatMap> heatMap = resolvedTestService.findByClassificationInterpretationHeatMap(interpretation);
        List<ResolvedTestResponseHeatMapTotalIntensity> heatMapTotalIntensity = heatMap.stream().map(
                resolvedTestResponseHeatMap -> resolvedTestService.fromResolvedTestResponseHeatMap(resolvedTestResponseHeatMap)
        ).toList();
        return ResponseEntity.ok(heatMapTotalIntensity);
    }

    @GetMapping("/findByTemplateTestNameAndClassificationInterpretationHeatMap")
    public ResponseEntity<?> findByTemplateTestNameAndClassificationInterpretationHeatMap(@RequestParam String name, @RequestParam String interpretation) {
        List<ResolvedTestResponseHeatMap> heatMap = resolvedTestService.findByTemplateTestNameAndClassificationInterpretationHeatMap(name, interpretation);
        List<ResolvedTestResponseHeatMapTotalIntensity> heatMapTotalIntensity = heatMap.stream().map(
                resolvedTestResponseHeatMap -> resolvedTestService.fromResolvedTestResponseHeatMap(resolvedTestResponseHeatMap)
        ).toList();
        return ResponseEntity.ok(heatMapTotalIntensity);
    }

    @GetMapping("/findByDateBetweenHeatMap")
    public ResponseEntity<?> findByDateBetweenHeatMap(@RequestParam Date fechaInicio, @RequestParam Date fechaFin) {
        List<ResolvedTestResponseHeatMap> heatMap = resolvedTestService.findByDateBetweenHeatMap(fechaInicio, fechaFin);
        List<ResolvedTestResponseHeatMapTotalIntensity> heatMapTotalIntensity = heatMap.stream().map(
                resolvedTestResponseHeatMap -> resolvedTestService.fromResolvedTestResponseHeatMap(resolvedTestResponseHeatMap)
        ).toList();
        return ResponseEntity.ok(heatMapTotalIntensity);
    }

    @GetMapping("/findByDateBetweenAndTemplateTestNameHeatMap")
    public ResponseEntity<?> findByDateBetweenAndTemplateTestNameHeatMap(@RequestParam Date fechaInicio, @RequestParam Date fechaFin, @RequestParam String name) {
        List<ResolvedTestResponseHeatMap> heatMap = resolvedTestService.findByDateBetweenAndTemplateTestNameHeatMap(fechaInicio, fechaFin, name);
        List<ResolvedTestResponseHeatMapTotalIntensity> heatMapTotalIntensity = heatMap.stream().map(
                resolvedTestResponseHeatMap -> resolvedTestService.fromResolvedTestResponseHeatMap(resolvedTestResponseHeatMap)
        ).toList();
        return ResponseEntity.ok(heatMapTotalIntensity);
    }

    @GetMapping("/findByDateBetweenAndClassificationInterpretationHeatMap")
    public ResponseEntity<?> findByDateBetweenAndClassificationInterpretationHeatMap(@RequestParam Date fechaInicio, @RequestParam Date fechaFin, @RequestParam String interpretation) {
        List<ResolvedTestResponseHeatMap> heatMap = resolvedTestService.findByDateBetweenAndClassificationInterpretationHeatMap(fechaInicio, fechaFin, interpretation);
        List<ResolvedTestResponseHeatMapTotalIntensity> heatMapTotalIntensity = heatMap.stream().map(
                resolvedTestResponseHeatMap -> resolvedTestService.fromResolvedTestResponseHeatMap(resolvedTestResponseHeatMap)
        ).toList();
        return ResponseEntity.ok(heatMapTotalIntensity);
    }

    @GetMapping("/findByDateBetweenAndTemplateTestNameAndClassificationInterpretationHeatMap")
    public ResponseEntity<?> findByDateBetweenAndTemplateTestNameAndClassificationInterpretationHeatMap(@RequestParam Date fechaInicio, @RequestParam Date fechaFin, @RequestParam String name, @RequestParam String interpretation) {
        List<ResolvedTestResponseHeatMap> heatMap = resolvedTestService.findByDateBetweenAndTemplateTestNameAndClassificationInterpretationHeatMap(fechaInicio, fechaFin, name, interpretation);
        List<ResolvedTestResponseHeatMapTotalIntensity> heatMapTotalIntensity = heatMap.stream().map(
                resolvedTestResponseHeatMap -> resolvedTestService.fromResolvedTestResponseHeatMap(resolvedTestResponseHeatMap)
        ).toList();
        return ResponseEntity.ok(heatMapTotalIntensity);
    }

}

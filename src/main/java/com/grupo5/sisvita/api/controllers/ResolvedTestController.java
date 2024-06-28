package com.grupo5.sisvita.api.controllers;

import com.grupo5.sisvita.api.dto.response.AnswerDTO;
import com.grupo5.sisvita.api.dto.response.RealizarVigilanciaDTO;
import com.grupo5.sisvita.api.dto.response.ResolvedTestDTO;
import com.grupo5.sisvita.api.entities.*;
import com.grupo5.sisvita.api.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/resolved-test")
public class ResolvedTestController {

    @Autowired
    private ResolvedTestService resolvedTestService;

    @Autowired
    private TemplateTestService templateTestService;

    @Autowired
    private ClassificationService classificationService;

    @Autowired
    private AlternativesService alternativesService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private PatientService patientService;

    @PostMapping()
    public ResponseEntity<?> createResolvedTest(@RequestBody ResolvedTestDTO resolvedTestDTO) {
        TemplateTest templateTest = templateTestService.findById(resolvedTestDTO.getTemplateTestId());

        Patient patient = patientService.findById(resolvedTestDTO.getIdPaciente());
        List<AnswerDTO> answersDTO = resolvedTestDTO.getAnswers();
        List<Answer> answers = new ArrayList<>();
        ResolvedTest resolvedTest = resolvedTestDTO.toEntity();

        for (AnswerDTO answerDTO : answersDTO) {
            Answer answer = new Answer();
            answer.setAlternative(alternativesService.findById(answerDTO.getIdAlternative()));
            answer.setQuestion(questionService.findById(answerDTO.getIdQuestion()));
            answer.setResolvedTest(resolvedTest);
            answers.add(answer);
        }

        resolvedTest.setTemplateTest(templateTest);
        resolvedTest.setAnswers(answers);
        resolvedTest.setPaciente(patient);

        resolvedTest.setResult(resolvedTestService.sumResultFromAlternatives(resolvedTest));

        Classification classification = classificationService.findByTemplateTestIdAndResult(templateTest.getId(), resolvedTest.getResult());

        resolvedTest.setClassification(classification);

        ResolvedTest savedResolvedTest = resolvedTestService.saveResolvedTest(resolvedTest);

        // agregar un message: "Test resuelto correctamente"
        Map<String, ?> response = Map.of("result", savedResolvedTest.getResult(), "interpretation", savedResolvedTest.getClassification().getInterpretation());
        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<Iterable<ResolvedTest>> findAll() {
        Iterable<ResolvedTest> resolvedTests = resolvedTestService.findAll();
        return ResponseEntity.ok(resolvedTests);
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

    @GetMapping("/findByTemplateTestName")
    public ResponseEntity<List<ResolvedTest>> findByTemplateTestName(@RequestParam String name) {
        List<ResolvedTest> resolvedTests = resolvedTestService.findByTemplateTestName(name);
        return ResponseEntity.ok().body(resolvedTests);
    }

    @GetMapping("/findByClassificationInterpretation")
    public ResponseEntity<List<ResolvedTest>> findByClassificationInterpretation(@RequestParam String interpretation) {
        List<ResolvedTest> resolvedTests = resolvedTestService.findByClassificationInterpretation(interpretation);
        return ResponseEntity.ok().body(resolvedTests);
    }

    @GetMapping("/findByTemplateTestNameAndClassificationInterpretation")
    public ResponseEntity<List<ResolvedTest>> findByTemplateTestNameAndClassificationInterpretation(@RequestParam String name, @RequestParam String interpretation) {
        List<ResolvedTest> resolvedTests = resolvedTestService.findByTemplateTestNameAndClassificationInterpretation(name, interpretation);
        return ResponseEntity.ok().body(resolvedTests);
    }

    @GetMapping("/findByDateBetween")
    public ResponseEntity<List<ResolvedTest>> findByDateBetween(@RequestParam Date fechaInicio, @RequestParam Date fechaFin) {
        List<ResolvedTest> resolvedTests = resolvedTestService.findByDateBetween(fechaInicio, fechaFin);
        return ResponseEntity.ok().body(resolvedTests);
    }

    @GetMapping("/findByDateBetweenAndTemplateTestName")
    public ResponseEntity<List<ResolvedTest>> findByDateBetweenAndTemplateTestName(@RequestParam Date fechaInicio, @RequestParam Date fechaFin, @RequestParam String name) {
        List<ResolvedTest> resolvedTests = resolvedTestService.findByDateBetweenAndTemplateTestName(fechaInicio, fechaFin, name);
        return ResponseEntity.ok().body(resolvedTests);
    }

    @GetMapping("/findByDateBetweenAndClassificationInterpretation")
    public ResponseEntity<List<ResolvedTest>> findByDateBetweenAndClassificationInterpretation(@RequestParam Date fechaInicio, @RequestParam Date fechaFin, @RequestParam String interpretation) {
        List<ResolvedTest> resolvedTests = resolvedTestService.findByDateBetweenAndClassificationInterpretation(fechaInicio, fechaFin, interpretation);
        return ResponseEntity.ok().body(resolvedTests);
    }

    @GetMapping("/findByDateBetweenAndTemplateTestNameAndClassificationInterpretation")
    public ResponseEntity<List<ResolvedTest>> findByDateBetweenAndTemplateTestNameAndClassificationInterpretation(@RequestParam Date fechaInicio, @RequestParam Date fechaFin, @RequestParam String name, @RequestParam String interpretation) {
        List<ResolvedTest> resolvedTests = resolvedTestService.findByDateBetweenAndTemplateTestNameAndClassificationInterpretation(fechaInicio, fechaFin, name, interpretation);
        return ResponseEntity.ok().body(resolvedTests);
    }
}

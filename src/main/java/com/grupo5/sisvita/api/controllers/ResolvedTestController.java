package com.grupo5.sisvita.api.controllers;

import com.grupo5.sisvita.api.dto.AlternativeDTO;
import com.grupo5.sisvita.api.dto.AnswerDTO;
import com.grupo5.sisvita.api.dto.ResolvedTestDTO;
import com.grupo5.sisvita.api.entities.*;
import com.grupo5.sisvita.api.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity<?> createResolvedTest(@RequestBody ResolvedTestDTO resolvedTestDTO) {
        TemplateTest templateTest = templateTestService.findById(resolvedTestDTO.getTemplateTestId());

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

        resolvedTest.setResult(resolvedTestService.sumResultFromAlternatives(resolvedTest));

        Classification classification = classificationService.findByTemplateTestIdAndResult(templateTest.getId(), resolvedTest.getResult());

        resolvedTest.setClassification(classification);

        ResolvedTest savedResolvedTest = resolvedTestService.saveResolvedTest(resolvedTest);

        // agregar un message: "Test resuelto correctamente"
        Map<String, String> response = Map.of("message", "Test resuelto correctamente");
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

    @GetMapping("/findById/{id}")
    public ResponseEntity<ResolvedTest> findById(@PathVariable Long id) {
        ResolvedTest resolvedTest = resolvedTestService.findById(id);
        return ResponseEntity.ok().body(resolvedTest);
    }
}

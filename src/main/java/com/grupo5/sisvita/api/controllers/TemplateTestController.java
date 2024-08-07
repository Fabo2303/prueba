package com.grupo5.sisvita.api.controllers;

import com.grupo5.sisvita.api.dto.response.templatetest.TemplateTestResponse;
import com.grupo5.sisvita.api.dto.response.templatetest.TemplateTestWithAlternativesAndQuestionsResponse;
import com.grupo5.sisvita.api.entities.Alternative;
import com.grupo5.sisvita.api.entities.Classification;
import com.grupo5.sisvita.api.entities.Question;
import com.grupo5.sisvita.api.entities.TemplateTest;
import com.grupo5.sisvita.api.services.TemplateTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/template-test")
public class TemplateTestController {
    @Autowired
    private TemplateTestService templateTestService;

    @PostMapping()
    public ResponseEntity<TemplateTest> createTemplateTest(@RequestBody TemplateTest templateTest) {
        for (Alternative alternative : templateTest.getAlternatives()) {
            alternative.setTemplateTest(templateTest);
        }
        for (Question question: templateTest.getQuestions()) {
            question.setTemplateTest(templateTest);
        }
        for (Classification classification: templateTest.getClassifications()) {
            classification.setTemplateTest(templateTest);
        }
        TemplateTest savedTemplateTest = templateTestService.saveTemplateTest(templateTest);
        return ResponseEntity.ok(savedTemplateTest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemplateTest> getTemplateTestById(@PathVariable Long id) {
        TemplateTest templateTest = templateTestService.findById(id);
        return ResponseEntity.ok(templateTest);
    }

    @GetMapping()
    public ResponseEntity<Iterable<TemplateTest>> getAllTemplateTests() {
        Iterable<TemplateTest> templateTests = templateTestService.findAll();
        return ResponseEntity.ok(templateTests);
    }

    @GetMapping("/dto")
    public ResponseEntity<Iterable<TemplateTestResponse>> getAllTemplateTestsDTO() {
        Iterable<TemplateTestResponse> templateTests = templateTestService.findAllTemplateTests();
        return ResponseEntity.ok(templateTests);
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<TemplateTestWithAlternativesAndQuestionsResponse> getTemplateTestDTOById(@PathVariable Long id) {
        TemplateTestWithAlternativesAndQuestionsResponse templateTest = templateTestService.findDtoById(id);
        return ResponseEntity.ok(templateTest);
    }

    @GetMapping("/name")
    public ResponseEntity<List<String>> getAllTemplateTestsName() {
        List<String> templateTests = templateTestService.findAllName();
        return ResponseEntity.ok(templateTests);
    }

    @GetMapping("/classification")
    public ResponseEntity<List<String>> getClassificationNameByName(@RequestParam String name) {
        List<String> classifications = templateTestService.findClassificationNameByName(name);
        return ResponseEntity.ok(classifications);
    }
}

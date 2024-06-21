package com.grupo5.sisvita.api.controllers;

import com.grupo5.sisvita.api.dto.AnswerDTO;
import com.grupo5.sisvita.api.entities.Answer;
import com.grupo5.sisvita.api.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @GetMapping()
    public ResponseEntity<Iterable<Answer>> findAll() {
        Iterable<Answer> answers = answerService.findAll();
        return ResponseEntity.ok(answers);
    }

    @GetMapping("/dto")
    public ResponseEntity<Iterable<AnswerDTO>> getAllAnswers() {
        Iterable<AnswerDTO> answers = answerService.findAllAnswers();
        return ResponseEntity.ok(answers);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Answer> findById(@PathVariable Long id) {
        Answer answer = answerService.findById(id);
        return ResponseEntity.ok().body(answer);
    }

    @PostMapping()
    public ResponseEntity<Answer> saveAnswer(@RequestBody Answer answer) {
        Answer newAnswer = answerService.saveAnswer(answer);
        return ResponseEntity.ok().body(newAnswer);
    }
}

package com.grupo5.sisvita.api.services;

import com.grupo5.sisvita.api.dto.ResolvedTestDTO;
import com.grupo5.sisvita.api.entities.Alternative;
import com.grupo5.sisvita.api.entities.Question;
import com.grupo5.sisvita.api.entities.ResolvedTest;
import com.grupo5.sisvita.api.repositories.ResolvedTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResolvedTestService {
    @Autowired
    private ResolvedTestRepository resolvedTestRepository;

    public ResolvedTest saveResolvedTest(ResolvedTest resolvedTest) {
        return resolvedTestRepository.save(resolvedTest);
    }

    public ResolvedTest findById(Long id) {
        return resolvedTestRepository.findById(id).orElse(null);
    }

    public List<ResolvedTest> findAll() {
        return resolvedTestRepository.findAll();
    }

    public List<ResolvedTestDTO> findAllResolvedTests() {
        List<ResolvedTest> resolvedTests = resolvedTestRepository.findAll();
        return resolvedTests.stream()
                .map(ResolvedTestDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public int sumResultFromAlternatives(ResolvedTest resolvedTest) {
        List<Question> questions = resolvedTest.getTemplateTest().getQuestions();
        List<Alternative> alternatives = resolvedTest.getTemplateTest().getAlternatives();
        int result = 0;
        for(int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            Alternative alternative = alternatives.get(i);
            if(question.isInverted()) {
                result += alternative.getInvertedScore();
            } else {
                result += alternative.getScore();
            }
        }
        return result;
    }
}

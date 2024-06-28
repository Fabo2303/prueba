package com.grupo5.sisvita.api.services;

import com.grupo5.sisvita.api.dto.response.TemplateTestDTO;
import com.grupo5.sisvita.api.entities.TemplateTest;
import com.grupo5.sisvita.api.repositories.TemplateTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemplateTestService {

    @Autowired
    private TemplateTestRepository templateTestRepository;

    public TemplateTest saveTemplateTest(TemplateTest templateTest) {
        return templateTestRepository.save(templateTest);
    }

    public TemplateTest findById(Long id) {
        return templateTestRepository.findById(id).orElse(null);
    }

    public List<TemplateTest> findAll() {
        return templateTestRepository.findAll();
    }

    public List<TemplateTestDTO> findAllTemplateTests() {
        List<TemplateTest> templateTests = templateTestRepository.findAll();
        return templateTests.stream()
                .map(TemplateTestDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public List<String> findAllName() {
        return templateTestRepository.findAllName();
    }

    public List<String> findClassificationNameByName(String name) {
        return templateTestRepository.findClassificationNameByName(name);
    }

}

package com.grupo5.sisvita.api.services;

import com.grupo5.sisvita.api.dto.requests.AnswerRequest;
import com.grupo5.sisvita.api.dto.requests.ResolvedTestRequest;
import com.grupo5.sisvita.api.dto.response.RealizarVigilanciaDTO;
import com.grupo5.sisvita.api.dto.response.ResolvedTestDTO;
import com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestReponseDataPatient;
import com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseHeatMap;
import com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseHeatMapTotalIntensity;
import com.grupo5.sisvita.api.dto.response.resolvedtest.ResolvedTestResponseTableFormat;
import com.grupo5.sisvita.api.entities.ResolvedTest;
import com.grupo5.sisvita.api.repositories.AnswerRepository;
import com.grupo5.sisvita.api.repositories.ResolvedTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ResolvedTestService {
    @Autowired
    private ResolvedTestRepository resolvedTestRepository;

    @Autowired
    private ClassificationService classificationService;

    @Autowired
    private AnswerRepository answerRepository;

    public Map<String, ?> saveResolvedTest(ResolvedTestRequest resolvedTestRequest) {
        int result = sumResultFromAlternatives(resolvedTestRequest.getAnswers());
        Long classificationId = classificationService.findByTemplateTestIdAndResult(resolvedTestRequest.getTemplateTestId(), result).getId();
        resolvedTestRepository.insert(resolvedTestRequest.getDate(), result, resolvedTestRequest.getTemplateTestId(), classificationId, resolvedTestRequest.getIdPaciente());
        ResolvedTest resolvedTest = resolvedTestRepository.findTopByPacienteIdOrderByDateDesc(resolvedTestRequest.getIdPaciente());
        for (AnswerRequest answerRequest : resolvedTestRequest.getAnswers()) {
            answerRepository.insert(answerRequest.getIdQuestion(), answerRequest.getIdAlternative(), resolvedTest.getId());
        }
        return Map.of("result", resolvedTest.getResult(), "interpretation", resolvedTest.getClassification().getInterpretation(), "color", resolvedTest.getClassification().getAnxietyColor().getColor());
    }

    public int sumResultFromAlternatives(List<AnswerRequest> answerRequests) {
        int result = 0;
        for (AnswerRequest answerRequest : answerRequests) {
            if (answerRequest.isInverted()) {
                result += answerRequest.getInvertedScore();
            } else {
                result += answerRequest.getScore();
            }
        }
        return result;
    }

    public ResolvedTestResponseHeatMapTotalIntensity fromResolvedTestResponseHeatMap(ResolvedTestResponseHeatMap resolvedTestResponseHeatMap) {
        return new ResolvedTestResponseHeatMapTotalIntensity(
                resolvedTestResponseHeatMap.getId(),
                resolvedTestResponseHeatMap.getUbigeo(),
                resolvedTestResponseHeatMap.getDepartamento(),
                resolvedTestResponseHeatMap.getLatitud(),
                resolvedTestResponseHeatMap.getLongitud(),
                resolvedTestResponseHeatMap.getIntensity(),
                resolvedTestResponseHeatMap.getUbigeoIntensityCount(),
                resolvedTestResponseHeatMap.getIntensity() * resolvedTestResponseHeatMap.getUbigeoIntensityCount()
        );
    }

    public ResolvedTest findById(Long id) {
        return resolvedTestRepository.findById(id).orElse(null);
    }

    public ResolvedTestReponseDataPatient findByIdAndReturnDataPatient(Long id) {
        ResolvedTest resolvedTest = resolvedTestRepository.findById(id).orElse(null);
        assert resolvedTest != null;
        return ResolvedTestReponseDataPatient.fromEntity(resolvedTest);
    }

    public List<ResolvedTest> findAll() {
        return resolvedTestRepository.findAll();
    }

    public List<ResolvedTestResponseTableFormat> findAllResolvedTestResponse() {
        return resolvedTestRepository.findAllResolvedTestsResponse();
    }

    public List<ResolvedTestDTO> findAllResolvedTests() {
        List<ResolvedTest> resolvedTests = resolvedTestRepository.findAll();
        return resolvedTests.stream()
                .map(ResolvedTestDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public List<RealizarVigilanciaDTO> realizarVigilancia() {
        List<ResolvedTest> resolvedTests = resolvedTestRepository.findAll();
        return resolvedTests.stream()
                .map(RealizarVigilanciaDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public List<ResolvedTestResponseTableFormat> findByTemplateTestName(String name) {
        return resolvedTestRepository.findByTemplateTestName(name);
    }

    public List<ResolvedTestResponseTableFormat> findByClassificationInterpretation(String interpretation) {
        return resolvedTestRepository.findByClassificationInterpretation(interpretation);
    }

    public List<ResolvedTestResponseTableFormat> findByTemplateTestNameAndClassificationInterpretation(String name, String interpretation) {
        return resolvedTestRepository.findByTemplateTestNameAndClassificationInterpretation(name, interpretation);
    }

    public List<ResolvedTestResponseTableFormat> findByDateBetweenAndTemplateTestName(Date fechaInicio, Date fechaFin, String name) {
        return resolvedTestRepository.findByDateBetweenAndTemplateTestName(fechaInicio, fechaFin, name);
    }

    public List<ResolvedTestResponseTableFormat> findByDateBetweenAndClassificationInterpretation(Date fechaInicio, Date fechaFin, String interpretation) {
        return resolvedTestRepository.findByDateBetweenAndClassificationInterpretation(fechaInicio, fechaFin, interpretation);
    }

    public List<ResolvedTestResponseTableFormat> findByDateBetween(Date fechaInicio, Date fechaFin) {
        return resolvedTestRepository.findByDateBetween(fechaInicio, fechaFin);
    }

    public List<ResolvedTestResponseTableFormat> findByDateBetweenAndTemplateTestNameAndClassificationInterpretation(Date fechaInicio, Date fechaFin, String name, String interpretation) {
        return resolvedTestRepository.findByDateBetweenAndTemplateTestNameAndClassificationInterpretation(fechaInicio, fechaFin, name, interpretation);
    }

    public List<ResolvedTestResponseHeatMap> findAllHeatMap() {
        return resolvedTestRepository.findAllResolvedTestHeatMap();
    }

    public List<ResolvedTestResponseHeatMap> findByDateBetweenHeatMap(Date fechaInicio, Date fechaFin) {
        return resolvedTestRepository.findByDateBetweenHeatMap(fechaInicio, fechaFin);
    }

    public List<ResolvedTestResponseHeatMap> findByDateBetweenAndTemplateTestNameHeatMap(Date fechaInicio, Date fechaFin, String name) {
        return resolvedTestRepository.findByDateBetweenAndTemplateTestNameHeatMap(fechaInicio, fechaFin, name);
    }

    public List<ResolvedTestResponseHeatMap> findByDateBetweenAndClassificationInterpretationHeatMap(Date fechaInicio, Date fechaFin, String interpretation) {
        return resolvedTestRepository.findByDateBetweenAndClassificationInterpretationHeatMap(fechaInicio, fechaFin, interpretation);
    }

    public List<ResolvedTestResponseHeatMap> findByDateBetweenAndTemplateTestNameAndClassificationInterpretationHeatMap(Date fechaInicio, Date fechaFin, String name, String interpretation) {
        return resolvedTestRepository.findByDateBetweenAndTemplateTestNameAndClassificationInterpretationHeatMap(fechaInicio, fechaFin, name, interpretation);
    }

    public List<ResolvedTestResponseHeatMap> findByTemplateTestNameHeatMap(String name) {
        return resolvedTestRepository.findByTemplateTestNameHeatMap(name);
    }

    public List<ResolvedTestResponseHeatMap> findByClassificationInterpretationHeatMap(String interpretation) {
        return resolvedTestRepository.findByClassificationInterpretationHeatMap(interpretation);
    }

    public List<ResolvedTestResponseHeatMap> findByTemplateTestNameAndClassificationInterpretationHeatMap(String name, String interpretation) {
        return resolvedTestRepository.findByTemplateTestNameAndClassificationInterpretationHeatMap(name, interpretation);
    }
}

package com.grupo5.sisvita.api.controllers;

import com.grupo5.sisvita.api.dto.response.PatientDTO;
import com.grupo5.sisvita.api.dto.requests.PatientRequest;
import com.grupo5.sisvita.api.entities.Patient;
import com.grupo5.sisvita.api.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping()
    public ResponseEntity<?> createPatient(@RequestBody PatientRequest patientRequest){
        Patient patient = patientService.savePatient(patientRequest);
        Map<String, String> response = new HashMap<>();
        if (patient == null) {
            response.put("error", "Error al crear paciente");
            return ResponseEntity.badRequest().body(response);
        }
        response.put("message", "Paciente creado con éxito");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id){
        Patient patient = patientService.findById(id);
        return ResponseEntity.ok(patient);
    }

    @GetMapping()
    public ResponseEntity<Iterable<Patient>> getAllPatients(){
        Iterable<Patient> patients = patientService.findAll();
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/dto")
    public ResponseEntity<Iterable<PatientDTO>> getAllPatientsDTO(){
        Iterable<PatientDTO> patients = patientService.findAllPatients();
        return ResponseEntity.ok(patients);
    }
}

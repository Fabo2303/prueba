package com.grupo5.sisvita.api.services;

import com.grupo5.sisvita.api.dto.SpecialistDTO;
import com.grupo5.sisvita.api.entities.Specialist;
import com.grupo5.sisvita.api.entities.User;
import com.grupo5.sisvita.api.repositories.SpecialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialistService {
    @Autowired
    private SpecialistRepository specialistRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public Specialist saveSpecialist(Specialist specialist) {
        User user = specialist.getUser();
        if (user != null) {
            user = userService.saveUser(user);
            specialist.setUser(user);
        }
        return specialistRepository.save(specialist);
    }

    public Specialist findById(Long id) {
        return specialistRepository.findById(id).orElse(null);
    }

    public Iterable<Specialist> findAll() {
        return specialistRepository.findAll();
    }

    public List<SpecialistDTO> findAllSpecialists() {
        List<Specialist> specialists = specialistRepository.findAll();
        return specialists.stream()
                .map(SpecialistDTO::fromEntity)
                .collect(Collectors.toList());
    }
}

package com.grupo5.sisvita.api.services;

import com.grupo5.sisvita.api.dto.UserDTO;
import com.grupo5.sisvita.api.entities.Persona;
import com.grupo5.sisvita.api.entities.User;
import com.grupo5.sisvita.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonaService personaService;

    @Transactional
    public User saveUser(User user) {
        Persona persona = user.getPersona();
        if (persona != null) {
            persona = personaService.savePersona(persona);
            user.setPersona(persona);
        }
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<UserDTO> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserDTO::fromEntity)
                .collect(java.util.stream.Collectors.toList());
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}

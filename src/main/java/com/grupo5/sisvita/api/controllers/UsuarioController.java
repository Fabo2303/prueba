package com.grupo5.sisvita.api.controllers;

import com.grupo5.sisvita.api.entities.Usuario;
import com.grupo5.sisvita.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody Usuario usuario){
        if(usuario == null){
            return ResponseEntity.badRequest().body("No se puede guardar un usuario nulo");
        }
        return ResponseEntity.ok().body("Usuario guardado con éxito");
    }

    @GetMapping("all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body("Lista de usuarios");
    }
}

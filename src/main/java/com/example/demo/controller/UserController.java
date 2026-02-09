package com.example.demo.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    private final UsuarioService usuarioService;

    public UserController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // @PatchMapping("/register")
    // public ResponseEntity<?> edit(@RequestBody Map<String, String> request){
    //     Usuario usuario = usuarioService.registrarUsuario(null);
    //     return ResponseEntity.ok(usuario);
    // }
}

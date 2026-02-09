package com.example.demo.controller;

import java.util.Map;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UsuarioService;

import io.jsonwebtoken.JwtBuilder;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request){
        Usuario usuario = usuarioService.registrarUsuario(request.get("username"), request.get("password"));
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request){
        Optional<Usuario> usuario = usuarioService.buscarPorUsername(request.get("username"));

        if (usuario.isPresent() && usuario.get().getPassword().equals(request.get("password"))) {
            JwtBuilder token  = JwtUtil.generateToken(usuario.get().getUsername());
            return ResponseEntity.ok(Map.of("token", token));
        }
        else {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }
    }
}

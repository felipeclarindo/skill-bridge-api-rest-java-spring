package com.example.skill_bridge.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.skill_bridge.config.JwtTokenProvider;
import com.example.skill_bridge.dto.UserDTO;
import com.example.skill_bridge.entity.User;
import com.example.skill_bridge.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Registro de usuário
    @PostMapping("/register")
    public String register(@Valid @RequestBody UserDTO userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            throw new RuntimeException("Usuário já existe!");
        }

        User user = new User();
        user.setUsername(userDTO.getUsername());
        // Codifica a senha antes de salvar
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(user);

        return "Usuário registrado com sucesso: " + user.getUsername();
    }

    // Login / autenticação
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserDTO userDTO) {
        User user = userRepository.findByUsername(userDTO.getUsername())
                .orElse(null);

        if (user == null || !passwordEncoder.matches(userDTO.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Usuário ou senha inválidos");
        }

        String token = jwtTokenProvider.generateToken(user.getUsername());
        return ResponseEntity.ok(Map.of("token", token, "type", "Bearer"));
    }

}

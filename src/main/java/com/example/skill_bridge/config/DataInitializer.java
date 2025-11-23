package com.example.skill_bridge.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.skill_bridge.entity.User;
import com.example.skill_bridge.repository.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Usuário padrão
        String defaultUsername = "admin";
        String defaultPassword = "admin123";

        if (!userRepository.existsByUsername(defaultUsername)) {
            User user = new User();
            user.setUsername(defaultUsername);
            user.setPassword(passwordEncoder.encode(defaultPassword));
            userRepository.save(user);
            System.out.println("Usuário padrão criado: " + defaultUsername);
        } else {
            System.out.println("Usuário padrão já existe: " + defaultUsername);
        }
    }
}

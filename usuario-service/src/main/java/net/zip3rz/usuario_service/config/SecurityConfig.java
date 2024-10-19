package net.zip3rz.usuario_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/usuarios/registro").permitAll()  // Permitir registro sin autenticación
                .anyRequest().authenticated()  // Otros endpoints requieren autenticación
            )
            .csrf(csrf -> csrf.disable());  // Desactivar CSRF para simplificar REST APIs

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        String secret = "mi_secreto_super_secreto"; // Cambia esto por una clave secreta segura.
        int saltLength = 16; // Longitud del salt en bytes.
        int iterations = 10000; // Número de iteraciones.
        
        // Usando PBKDF2WithHmacSHA256 como algoritmo de fábrica de claves.
        return new Pbkdf2PasswordEncoder(secret, saltLength, iterations, 
                Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);
    }
}

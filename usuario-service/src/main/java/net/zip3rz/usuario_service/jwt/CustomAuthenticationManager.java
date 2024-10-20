package net.zip3rz.usuario_service.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import net.zip3rz.usuario_service.model.Usuario;
import net.zip3rz.usuario_service.service.UsuarioService;

@Component
public class CustomAuthenticationManager implements AuthenticationManager {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        Usuario user = usuarioService.findByNombre(username).orElseThrow(() -> new BadCredentialsException("Credenciales inválidas"));
        if (user != null && passwordEncoder.matches(password, user.getContrasena())) {
            return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
        } else {
            throw new BadCredentialsException("Credenciales inválidas");
        }
    }
    
}


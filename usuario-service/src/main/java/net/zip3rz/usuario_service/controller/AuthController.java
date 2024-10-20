package net.zip3rz.usuario_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.zip3rz.usuario_service.jwt.AuthRequest;
import net.zip3rz.usuario_service.jwt.AuthResponse;
import net.zip3rz.usuario_service.jwt.JwtUtil;
import net.zip3rz.usuario_service.model.Usuario;
import net.zip3rz.usuario_service.service.CustomUserDetailsService;
import net.zip3rz.usuario_service.service.UsuarioService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private CustomUserDetailsService userDetailsService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.registrarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        // Cargar los detalles del usuario
        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getNombre());
        
        // Comprobar si el usuario existe y la contraseña es correcta
        if (userDetails != null && passwordEncoder.matches(authRequest.getContrasena(), userDetails.getPassword())) {
            // Generar JWT
            final String jwt = jwtUtil.generateToken(userDetails);
            return ResponseEntity.ok(new AuthResponse(jwt));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrectos");
        }
    }

    
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Test endpoint is working");
    }
}


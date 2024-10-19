package net.zip3rz.usuario_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.zip3rz.usuario_service.model.Usuario;
import net.zip3rz.usuario_service.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
    private UsuarioRepository usuarioRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/registro")
    public Usuario registro(@RequestBody Usuario usuario) {
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        usuario.setRol("USER");
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/login")
    public String login() {
        return "Autenticado";
    }
}


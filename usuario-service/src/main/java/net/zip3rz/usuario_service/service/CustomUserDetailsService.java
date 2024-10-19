package net.zip3rz.usuario_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import net.zip3rz.usuario_service.model.Usuario;
import net.zip3rz.usuario_service.repository.UsuarioRepository;

public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository userRepository;
	
    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        Usuario user = userRepository.findByNombre(nombre)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return User.withUsername(user.getNombre())
            .password(user.getContrasena())
            .roles(user.getRol())  // Puedes usar 'ROLE_USER', 'ROLE_ADMIN', etc.
            .build();
    }
	
}

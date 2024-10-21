package net.zip3rz.usuario_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.zip3rz.usuario_service.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario>findByNombre(String nombre);
	
}

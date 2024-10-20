package net.zip3rz.usuario_service.jwt;

import lombok.Data;

@Data
public class AuthRequest {
    
	private String nombre;
    
	private String contrasena;
	
}

package net.zip3rz.usuario_service.jwt;

import lombok.Data;

@Data
public class AuthResponse {
    
	private String jwt;
    
	public AuthResponse(String jwt) {
		this.jwt = jwt;
	}
	
}

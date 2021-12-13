package com.nezttech.kanban.payload.response;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @author NezTTech
 * @version 1.0
 * @since   2021-12-01
*/
@Getter
@Setter
public class JwtResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String token;

	private String type = "Bearer";

	private Long id;
 
	private String username;
 
	private String email;
 
	private List<String> roles;
	
	public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}

}

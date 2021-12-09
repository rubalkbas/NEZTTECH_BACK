package com.nezttech.kanban.security.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DetalleUsuarioImpl {
	
	/*private static final long serialVersionUID = 1L;
	
	private Long id;

	private String username;

	private String email;
	
	@JsonIgnore
	private String password;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	public DetalleUsuarioImpl(Long id, String username, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
		
		
		
	}	

	public static DetalleUsuarioImpl build(Usuario usuarios) {
		
		List<GrantedAuthority> authorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");

		return new DetalleUsuarioImpl(
				usuarios.getId(), 
				usuarios.getNombreUsuario(), 
				usuarios.getCorreo(),
				usuarios.getPass(), 
				authorities);
	}	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		DetalleUsuarioImpl user = (DetalleUsuarioImpl) o;
		return Objects.equals(id, user.id);
	}*/

}

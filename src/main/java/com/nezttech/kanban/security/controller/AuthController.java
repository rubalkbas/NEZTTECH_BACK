package com.nezttech.kanban.security.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nezttech.kanban.entity.NztUsuario;
import com.nezttech.kanban.model.Parametros;
import com.nezttech.kanban.model.Respuesta;
import com.nezttech.kanban.payload.response.JwtResponse;
import com.nezttech.kanban.security.jwt.JwtUtils;
import com.nezttech.kanban.security.repository.UsuarioRepository;
import com.nezttech.kanban.security.service.DetalleUsuarioImpl;

/**
 * @author NezTTech
 * @version 1.0
 * @since   2021-12-01
*/
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/authentication")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@PostMapping("/inicioSesion")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody Parametros parametros) {
		
		NztUsuario usuarios = new NztUsuario();
		Respuesta response = new Respuesta();
		
		usuarios = usuarioRepository.usuarioHabilitado(parametros.getCorreo());
		
		if(usuarios == null) {
			
			response.setMensaje("El correo aún no ha sido Registrado!!!");
			response.setValor("0");
			return new ResponseEntity<>(response, HttpStatus.OK);
			
		}else if(usuarios.getConfirmaCorreo() == 0) {
			
			response.setMensaje("El correo aún no ha sido confirmado!!!");
			response.setValor("1");
			return new ResponseEntity<>(response, HttpStatus.OK);
			
		}else if(usuarios.getConfirmaCorreo() == 1){
			
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(parametros.getCorreo(), parametros.getPass()));

			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication);
			
			DetalleUsuarioImpl userDetails = (DetalleUsuarioImpl) authentication.getPrincipal();		
			List<String> roles = userDetails.getAuthorities().stream()
					.map(item -> item.getAuthority())
					.collect(Collectors.toList());

			return ResponseEntity.ok(new JwtResponse(jwt, 
													 userDetails.getId(), 
													 userDetails.getUsername(), 
													 userDetails.getEmail(),
													 roles));			
			
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK);		
		
	}

}

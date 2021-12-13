package com.nezttech.kanban.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nezttech.kanban.entity.NztUsuario;
import com.nezttech.kanban.security.repository.UsuarioRepository;

/**
 * @author NezTTech
 * @version 1.0
 * @since   2021-12-01
*/
@Service
public class DetalleUsuarioInternoServiceImpl implements UserDetailsService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String idEmpleado) throws UsernameNotFoundException {
		NztUsuario usuario = usuarioRepository.obtenerPorIdEmpleado(idEmpleado, "1")
				.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el ID: " + idEmpleado));
	
		return DetalleUsuarioImpl.build(usuario);
	}

}

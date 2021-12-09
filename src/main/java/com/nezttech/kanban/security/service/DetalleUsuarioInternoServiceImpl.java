package com.nezttech.kanban.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Eduardo Nuñez
 * @version 1.0
 * @since   2021-11-27
 */

@Service
public class DetalleUsuarioInternoServiceImpl  {
	
	/*@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String idEmpleado) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.obtenerPorIdEmpleado(idEmpleado, "1")
				.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el ID: " + idEmpleado));
	
		return DetalleUsuarioImpl.build(usuario);
	}*/

}

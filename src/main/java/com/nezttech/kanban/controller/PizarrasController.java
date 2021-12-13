/**
 * 
 */
package com.nezttech.kanban.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nezttech.kanban.entity.nztPizarraUsuariosUrlFoto;
import com.nezttech.kanban.entity.nztUsuarioPizarra;
import com.nezttech.kanban.entity.nztUsuarios;
import com.nezttech.kanban.model.Respuesta;
import com.nezttech.kanban.service.IEjemploService;
import com.nezttech.kanban.service.IPizarraService;

/**
 * @author rubal
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pizarras")
public class PizarrasController {
	
private static final Logger LOGGER = LoggerFactory.getLogger(EjemploController.class);
	
	@Autowired
	private IPizarraService iPizarraService;
	
	@GetMapping(value = "/consultaPizarras",  produces = MediaType.APPLICATION_JSON_VALUE )
	public  ResponseEntity<Respuesta> consultaEjemplo() {
		
		LOGGER.info("EjemploController consulta todas las pizarras Entra");
	
		Respuesta response = new Respuesta();
		
		List<nztPizarraUsuariosUrlFoto> usuarios = new ArrayList<nztPizarraUsuariosUrlFoto>();
		
		usuarios = iPizarraService.consultaPizarras();
		
		response.setLista(usuarios);
		response.setValor("el nalga me la chupa");
		response.setEstatus("ok");
		response.setMensaje("Consulta exitosa - Sin datos en la bd");
		
		LOGGER.info("EjemploController consultaEjemplo Sale");
		
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
	@GetMapping(value = "/consultaPizarrasUsuario",  produces = MediaType.APPLICATION_JSON_VALUE )
	public  ResponseEntity<Respuesta> consultaUsuarioPizarra() {
		
		LOGGER.info("EjemploController consulta todas las pizarras Entra");
	
		Respuesta response = new Respuesta();
		
		List<nztUsuarioPizarra> usuarios = new ArrayList<nztUsuarioPizarra>();
		
		usuarios = iPizarraService.consultaPizarrasUsuario();
		
		response.setLista(usuarios);
		response.setValor("el nalga me la chupa");
		response.setEstatus("ok");
		response.setMensaje("Consulta exitosa - Sin datos en la bd");
		
		LOGGER.info("EjemploController consultaEjemplo Sale");
		
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}

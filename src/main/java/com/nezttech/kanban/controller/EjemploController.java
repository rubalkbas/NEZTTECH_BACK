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

import com.nezttech.kanban.entity.NztUsuario;
import com.nezttech.kanban.model.Respuesta;
import com.nezttech.kanban.service.IEjemploService;

/**
 * @author NezTTech
 * @version 1.0
 * @since   2021-12-01
*/
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ejemplo")
public class EjemploController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EjemploController.class);
	
	@Autowired
	private IEjemploService iEjemploService;
	
	@GetMapping(value = "/consultaEjemplo",  produces = MediaType.APPLICATION_JSON_VALUE )
	public  ResponseEntity<Respuesta> consultaEjemplo() {
		
		LOGGER.info("EjemploController consultaEjemplo Entra");
	
		Respuesta response = new Respuesta();
		
		List<NztUsuario> usuarios = new ArrayList<NztUsuario>();
		
		usuarios = iEjemploService.consultaEjemplo();
		
		response.setLista(usuarios);
		response.setValor("tu mama es hombre");
		response.setEstatus("ok");
		response.setMensaje("Consulta exitosa - Sin datos en la bd");
		
		LOGGER.info("EjemploController consultaEjemplo Sale");
		
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}

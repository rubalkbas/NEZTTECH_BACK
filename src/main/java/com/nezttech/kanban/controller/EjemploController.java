package com.nezttech.kanban.controller;

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

import com.nezttech.kanban.model.Respuesta;
import com.nezttech.kanban.service.IEjemploService;

/**
 * @author Nezttech
 *
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
		String respuesta = "";
		
		respuesta = iEjemploService.consultaEjemplo();
		
		response.setValor(respuesta);
		response.setEstatus("ok");
		response.setMensaje("Consulta exitosa - Sin datos en la bd");
		
		LOGGER.info("EjemploController consultaEjemplo Sale");
		
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}

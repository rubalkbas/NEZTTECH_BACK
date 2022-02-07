/**
 * 
 */
package com.nezttech.kanban.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nezttech.kanban.entity.NztTareas;
import com.nezttech.kanban.model.Respuesta;
import com.nezttech.kanban.service.ITareasService;


/**
 * @author rubal
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tareas")
public class TareasController {

	
private static final Logger LOGGER = LoggerFactory.getLogger(EjemploController.class);

@Autowired
ITareasService iTareasService;

@PostMapping(value = "/consultaCategoriaHija")
public ResponseEntity<Respuesta> fechaPermitidaComite(
		@RequestParam (name = "idPizarra") Long idPizarra) {

	LOGGER.info("Entra a controller para saber si la fecha ingresada es permitidad !!!");
	
	Respuesta response = new Respuesta();
	List <NztTareas> maestraCategoria;
	
	maestraCategoria = iTareasService.consultaTareasPorPizarra( idPizarra );
	
	if (maestraCategoria.isEmpty()) {
		response.setMensaje("ULTIMO");
	}else {
		response.setLista(maestraCategoria);
		response.setMensaje("consulta exitosa");
	}


	return new ResponseEntity<>(response, HttpStatus.OK);
}
}

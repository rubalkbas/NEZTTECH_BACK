package com.nezttech.kanban.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Nezttech
 *
 */
@Service
public class EjemploService implements IEjemploService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EjemploService.class);
	
	@Override
	public String consultaEjemplo(){
		
		LOGGER.info("EjemploService consultaEjemplo Entra");
		
		String respuesta="Prueba service";
		
		//llamado de metodo de rpository
		
		LOGGER.info("EjemploService consultaEjemplo Sale");
		
		return respuesta;
		
	}

}

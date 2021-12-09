package com.nezttech.kanban.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nezttech.kanban.entity.nztUsuarios;
import com.nezttech.kanban.security.repository.EjemploRepository;

/**
 * @author Nezttech
 *
 */
@Service
public class EjemploService implements IEjemploService{
	
	
	@Autowired
	private EjemploRepository  ejemploRepository;
	
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EjemploService.class);
	
	@Override
	public List<nztUsuarios> consultaEjemplo(){
		
		LOGGER.info("EjemploService consultaEjemplo Entra");
		
	
		List<nztUsuarios> lista = new ArrayList<nztUsuarios>();
		int ultimoRegistro;		
		
		lista = ejemploRepository.findAll();
		
	
		return lista;
		
	}

}

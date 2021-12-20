package com.nezttech.kanban.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nezttech.kanban.entity.NztUsuario;
import com.nezttech.kanban.repository.EjemploRepository;

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
	public List<NztUsuario> consultaEjemplo(){
		
		LOGGER.info("EjemploService consultaEjemplo Entra");
		
	
		List<NztUsuario> lista = new ArrayList<NztUsuario>();
		
		lista = ejemploRepository.findAll();
		
	
		return lista;
		
	}

}

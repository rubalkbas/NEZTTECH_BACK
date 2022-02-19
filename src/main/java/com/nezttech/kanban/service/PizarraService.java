/**
 * 
 */
package com.nezttech.kanban.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nezttech.kanban.entity.NztPizarraId;
import com.nezttech.kanban.entity.nztPizarraUsuariosUrlFoto;
import com.nezttech.kanban.entity.nztUsuarioPizarra;
import com.nezttech.kanban.repository.DetallePizarraUsuario;
import com.nezttech.kanban.repository.PizarraIdRepository;
import com.nezttech.kanban.repository.PizarraUsuarioFotoRepository;


/**
 * @author rubal
 *
 */
@Service
public class PizarraService implements IPizarraService{

private static final Logger LOGGER = LoggerFactory.getLogger(EjemploService.class);
	

@Autowired
private PizarraUsuarioFotoRepository pizarraUsuarioFotoRepository;

@Autowired
PizarraIdRepository pizarraIdRepository;

@Autowired
private DetallePizarraUsuario detallePizarraUsuario;



@Override
public List<nztPizarraUsuariosUrlFoto> consultaPizarras(){
	
	LOGGER.info("EjemploService consultaEjemplo Entra");
	

	List<nztPizarraUsuariosUrlFoto> lista = new ArrayList<nztPizarraUsuariosUrlFoto>();
	
	lista = pizarraUsuarioFotoRepository.findAll();
	

	return lista;
	
}

@Override
public List<NztPizarraId> consultaPizarrasId(Long idPizarra){
	
	LOGGER.info("EjemploService consultaEjemplo Entra");
	

	List<NztPizarraId> listaFinal = new ArrayList<NztPizarraId>();
	Optional<NztPizarraId> lista = Optional.empty();
	
	lista = pizarraIdRepository.findById(idPizarra);
	
	listaFinal = toList(lista);

	return listaFinal;
	
}

public static <T> List<T> toList(Optional<T> opt) {
    return opt
            .map(Collections::singletonList)
            .orElseGet(Collections::emptyList);
}

@Override
public List<nztUsuarioPizarra> consultaPizarrasUsuario(){
	
	LOGGER.info("EjemploService consultaEjemplo Entra");
	

	List<nztUsuarioPizarra> lista = new ArrayList<nztUsuarioPizarra>();
	
	lista = detallePizarraUsuario.findAll();
	

	return lista;
	
}

	
}

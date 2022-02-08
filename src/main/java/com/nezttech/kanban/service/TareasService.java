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

import com.nezttech.kanban.entity.NztTareas;
import com.nezttech.kanban.entity.nztPizarraUsuariosUrlFoto;
import com.nezttech.kanban.repository.TareasRepository;

/**
 * @author rubal
 *
 */
@Service
public class TareasService implements ITareasService{

private static final Logger LOGGER = LoggerFactory.getLogger(EjemploService.class);
	
@Autowired
TareasRepository tareasRepository;

@Override
public List<NztTareas> consultaTareasPorPizarra(Long idPizarra){
	
	LOGGER.info("Consulta tareas por pizarra Entra al service");
	

	List <NztTareas> maestraTareas;
	
	maestraTareas = tareasRepository.consultaPorIdpizarra(idPizarra);
	

	return maestraTareas;
	
}

public static <T> List<T> toList(Optional<T> opt) {
    return opt
            .map(Collections::singletonList)
            .orElseGet(Collections::emptyList);
}
}

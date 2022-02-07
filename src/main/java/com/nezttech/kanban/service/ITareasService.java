/**
 * 
 */
package com.nezttech.kanban.service;

import java.util.List;
import java.util.Optional;

import com.nezttech.kanban.entity.NztTareas;
import com.nezttech.kanban.entity.nztPizarraUsuariosUrlFoto;

/**
 * @author rubal
 *
 */
public interface ITareasService {

	List<NztTareas> consultaTareasPorPizarra(Long idPizarra);

}

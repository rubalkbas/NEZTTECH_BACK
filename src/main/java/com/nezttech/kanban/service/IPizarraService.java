/**
 * 
 */
package com.nezttech.kanban.service;

import java.util.List;

import com.nezttech.kanban.entity.nztPizarraUsuariosUrlFoto;
import com.nezttech.kanban.entity.nztUsuarioPizarra;

/**
 * @author Ruben Vazquez
 *
 */
public interface IPizarraService {

	
	/**
	 * consultaEjemplo
	 * @return String String
	 */
	List<nztPizarraUsuariosUrlFoto> consultaPizarras()  ;
	
	/**
	 * consultaEjemplo
	 * @return String String
	 */
	List<nztUsuarioPizarra> consultaPizarrasUsuario()  ;
	
	
	
	
}

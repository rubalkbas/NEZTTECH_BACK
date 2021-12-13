/**
 * 
 */
package com.nezttech.kanban.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nezttech.kanban.entity.nztUsuarioPizarra;
import com.nezttech.kanban.entity.nztUsuarios;

/**
 * @author rubal
 *
 */
public interface DetallePizarraUsuario extends JpaRepository<nztUsuarioPizarra, Long> {

}

/**
 * 
 */
package com.nezttech.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nezttech.kanban.entity.nztUsuarioPizarra;


/**
 * @author rubal
 *
 */
public interface DetallePizarraUsuario extends JpaRepository<nztUsuarioPizarra, Long> {

}

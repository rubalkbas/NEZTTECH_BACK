/**
 * 
 */
package com.nezttech.kanban.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nezttech.kanban.entity.NztUsuario;

/**
 * @author rubal
 *
 */
@Repository
public interface EjemploRepository extends JpaRepository<NztUsuario, Long> {
	
	@Query(value = "SELECT * FROM nzt_usuarios", nativeQuery = true)
	List<NztUsuario> buscaTodo();
	
	

}

/**
 * 
 */
package com.nezttech.kanban.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nezttech.kanban.entity.nztUsuarios;

/**
 * @author rubal
 *
 */
@Repository
public interface EjemploRepository extends JpaRepository<nztUsuarios, Long> {
	
	@Query(value = "SELECT * FROM nzt_usuarios", nativeQuery = true)
	List<nztUsuarios> buscaTodo();

}

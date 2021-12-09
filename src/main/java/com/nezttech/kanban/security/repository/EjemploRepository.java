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
	
	@Query(value = "SELECT * \r\n" + 
			"	FROM bdglobal.gbl_cat_cargo c \r\n" + 
			"		where id_cargo not in(\r\n" + 
			"        (SELECT a.id_cargo\r\n" + 
			"			FROM bdglobal.gbl_usuario_comite  b  \r\n" + 
			"			inner join bdglobal.gbl_cat_cargo a on  a.id_cargo = b.id_cargo\r\n" + 
			"			and b.estatus = 1 where b.id_comite = :id_comite))", nativeQuery = true)
	List<nztUsuarios> cargosSinSeleccionar(@Param("id_comite") int id_comite);

}

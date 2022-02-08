/**
 * 
 */
package com.nezttech.kanban.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
 
import com.nezttech.kanban.entity.NztTareas;

/**
 * @author rubal
 *
 */
@Repository
public interface TareasRepository extends JpaRepository<NztTareas, Long>{
	
	@Query(value = "select * from nzt_tareas where  trim(id_pizarra) =  trim(:idPizarra) ", nativeQuery = true)
    List <NztTareas> consultaPorIdpizarra(@Param("idPizarra") Long idPizarra);


}

/**
 * 
 */
package com.nezttech.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nezttech.kanban.entity.NztPizarraId;

/**
 * @author rubal
 *
 */
public interface PizarraIdRepository extends JpaRepository<NztPizarraId, Long>{
	

}

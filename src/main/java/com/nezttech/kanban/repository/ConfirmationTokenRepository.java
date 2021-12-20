package com.nezttech.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nezttech.kanban.model.ConfirmationToken;

/**
 * @author NezTTech
 * @version 1.0
 * @since   2021-12-01
*/
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken , Long> {
	
	@Query(value = "SELECT * FROM kanban_db.gen_aux_confirmacion_token where confirmation_token = :token", nativeQuery = true)
	 ConfirmationToken findByConfirmationToken(@Param("token") String confirmationTokens);

}

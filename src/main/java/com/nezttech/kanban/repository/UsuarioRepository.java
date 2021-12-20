package com.nezttech.kanban.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nezttech.kanban.entity.NztUsuario;

/**
 * @author NezTTech
 * @version 1.0
 * @since   2021-12-01
*/
@Repository
public interface UsuarioRepository extends JpaRepository<NztUsuario, Long>{
	
	@Query(value = "select * from kanban_db.nzt_usuarios WHERE  CORREO = :correo ", nativeQuery = true)
	NztUsuario usuarioHabilitado(@Param("correo") String correo);
	
	@Query(value = "SELECT * FROM kanban_db.nzt_usuarios WHERE correo = :correo and num_estatus = :estatus", nativeQuery = true)
	Optional<NztUsuario> obtenerPorIdEmpleado(String correo, String estatus);

}

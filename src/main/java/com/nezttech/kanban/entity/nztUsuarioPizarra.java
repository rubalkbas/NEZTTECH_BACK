/**
 * 
 */
package com.nezttech.kanban.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author rubal
 *
 */
@Entity
@Builder
@Table(name = "nzt_usuario_pizarra", schema = "kanban_db")
@Getter
@Setter
public class nztUsuarioPizarra {

	@Id
	@Column(name = "ID_USUARIO_PIZARRA")
	private Long idUsuarioPízarra;

	
	@Column(name = "ID_PIZARRA")
	private String idPizarra;
	
	@Column(name = "FCH_ASIGNACION")
	private String fchAsignacion;

	@Column(name = "NUM_ESTATUS")
	private String numStatus;
	
	@Column(name = "TXT_TIPO_USUARIO")
	private String txtTipoUsuario;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_USUARIO")
	private NztUsuario usuarioDetalle;

	public nztUsuarioPizarra() {
		
	}
	
	public nztUsuarioPizarra(Long idUsuarioPízarra, String idPizarra, String fchAsignacion, String numStatus,
			String txtTipoUsuario, NztUsuario usuarioDetalle) {
		super();
		this.idUsuarioPízarra = idUsuarioPízarra;
		this.idPizarra = idPizarra;
		this.fchAsignacion = fchAsignacion;
		this.numStatus = numStatus;
		this.txtTipoUsuario = txtTipoUsuario;
		this.usuarioDetalle = usuarioDetalle;
	}


	
	
}

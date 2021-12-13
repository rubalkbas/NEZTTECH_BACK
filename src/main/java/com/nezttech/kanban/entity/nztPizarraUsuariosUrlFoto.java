/**
 * 
 */
package com.nezttech.kanban.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rubal
 *
 */
@Entity
@Table(name = "nzt_pizarras", schema = "kanban_db")
@Getter
@Setter
public class nztPizarraUsuariosUrlFoto {
	
	@Id
	@Column(name = "ID_PIZARRA")
	private Long idPizarra;

	@Column(name = "TXT_TIPO_PIZARRA")
	private String txtTipoPizarra;
	
	@Column(name = "TXT_NOMBRE_PIZARRA")
	private String txtNombrePizarra;
	
	
	@Column(name = "FCH_CREACION")
	private Date fchCreacion;
	
	
	@Column(name = "TXT_DSC_CORTA")
	private String txtDescCorta;
	
	
	@Column(name = "TXT_VISIBILIDAD")
	private String txtVisibilidad;
	
	
	@Column(name = "NUM_ESTATUS")
	private Integer status;
	
	@OneToMany(targetEntity = nztUsuarioPizarra.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_PIZARRA", referencedColumnName = "ID_PIZARRA" )
	private List<nztUsuarioPizarra> usuarios ;

}

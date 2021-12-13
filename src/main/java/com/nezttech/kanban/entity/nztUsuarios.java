/**
 * 
 */
package com.nezttech.kanban.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "nzt_usuarios", schema = "kanban_db")
@Getter
@Setter
public class nztUsuarios implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	/** Retorna el estatus de la peticion o codigo */

	@Id
	@Column(name = "ID_USUARIO")
	private Long idUsuario;

	@Column(name = "TXT_NOMBRE")
	private String nombre;
	
	@Column(name = "TXT_AP_PA")
	private String apPa;
	
	@Column(name = "TXT_AP_MA")
	private String apMa;
	
	@Column(name = "TXT_CURP")
	private String curp;
	
	@Column(name = "TXT_RFC")
	private String rfc;
	
	@Column(name = "FCH_NACIMIENTO")
	private Date fchNac;
	
	@Column(name = "FCH_REGISTRO")
	private Date fchReg;
	
	@Column(name = "NUM_ESTATUS")
	private Integer estatus;
	
	@Column(name = "TXT_USUARIO")
	private String usuario;
	
	@Column(name = "TXT_PASS")
	private String pass;
	
	@Column(name = "TXT_URL_FOTO")
	private String urlFoto;
	
	@Column(name = "NUM_ID_PUESTO")
	private Integer idPuesto;
	
	@Column(name = "ID_PERFIL")
	private Integer idPerfil;
	
	@Column(name = "FCH_CONTRATO")
	private Date fchContrato;
	
	@Column(name = "ID_ESTUDIOS")
	private Integer idEstudios;



	

}

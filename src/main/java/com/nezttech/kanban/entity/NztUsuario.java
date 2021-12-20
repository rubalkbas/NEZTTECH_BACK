/**
 * 
 */
package com.nezttech.kanban.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author NezTTech
 * @version 1.0
 * @since   2021-12-01
*/
@Entity
@Table(name = "nzt_usuarios", schema = "kanban_db")
@Getter
@Setter
@NoArgsConstructor
public class NztUsuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/** Retorna el estatus de la peticion o codigo */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_USUARIO")
	private Long idUsuario;
	
	@Column(name = "NOMBRE_USUARIO")
	private String nombreUsuario;

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
	private int estatus;
	
	@Column(name = "TXT_USUARIO")
	private String usuario;
	
	@Column(name = "TXT_PASS")
	private String pass;
	
	@Column(name = "TXT_URL_FOTO")
	private String urlFoto;
	
	@Column(name = "ID_PERFIL")
	private int idPerfil;	
	
	@Column(name = "FCH_CONTRATO")
	private Date fchContrato;
	
	@Column(name = "ID_ESTUDIOS")
	private int idEstudios;
	
	@Column(name = "CORREO")
	private String correo;
	
	@Column(name = "CONFIRMA_CORREO")
	private int confirmaCorreo;

	public NztUsuario(String nombreUsuario, String correo, String pass) {
		this.nombreUsuario = nombreUsuario;
		this.correo = correo;
		this.pass = pass;
	}	

}

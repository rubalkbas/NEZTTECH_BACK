/**
 * 
 */
package com.nezttech.kanban.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rubal
 *
 */
@Entity
@Table(name = "nzt_usuarios", schema = "root" )
@Getter
@Setter
public class nztUsuarios {
	
private static final long serialVersionUID = 1L;
	
	/** Retorna el estatus de la peticion o codigo*/

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "ID_USUARIO")
	private  Number idUsuario  ;   

@Column(name = "TXT_NOMBRE")
	private  String nombre     ;
@Column(name = "TXT_AP_PA")
	private  String apPa       ;
@Column(name = "TXT_AP_MA")
	private  String apMa       ;
@Column(name = "TXT_CURP")
	private  String curp       ;
@Column(name = "TXT_RFC")
	private  String rfc        ;
@Column(name = "FCH_NACIMIENTO")
	private  Date fchNac       ;
@Column(name = "FCH_REGISTRO")
	private  Date fchReg       ;
@Column(name = "NUM_ESTATUS")
	private  Number estatus    ;
@Column(name = "TXT_USUARIO")
	private  String usuario    ;
@Column(name = "TXT_PASS")
	private  String pass       ;
@Column(name = "TXT_URL_FOTO")
	private  String urlFoto    ;
@Column(name = "NUM_ID_PUESTO")
	private  Number idPuesto   ;
@Column(name = "ID_PERFIL")
	private  Number idPerfil   ;  
@Column(name = "FCH_CONTRATO")
	private  Date fchContrato  ; 
@Column(name = "ID_ESTUDIOS")
	private  Number idEstudios ; 
	
	

}

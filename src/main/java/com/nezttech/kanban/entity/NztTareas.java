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
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author rubal
 *
 */
@Entity
@Table(name = "nzt_tareas", schema = "kanban_db")
@Getter
@Setter
@NoArgsConstructor
public class NztTareas {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_TAREA")
	private Long idTarea;
	
 
	@Column(name = "TXT_DESCRIPCION")
	private String descripcion;
	
	@Column(name = "TXT_COMENTARIOS")
	private String comentarios;
	
	@Column(name = "FCH_ASIGNACION")
	private Date fchAsignacion;
	
	@Column(name = "FCH_TERMINO_ESTIMADO")
	private Date fchTermEstimado;
	
	@Column(name = "FCH_TERMINO_REAL")
	private Date fchTermReal;
	
	@Column(name = "ID_USUARIO_ASIGNADO")
	private Long idUsuario;
	
	@Column(name = "ID_PIZARRA")
	private Long isPizarra;
	
	@Column(name = "TXT_PRIORIDAD")
	private String prioridad;
	
	@Column(name = "TXT_ESTATUS")
	private String estatus;
	

	
}

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
@Table(name = "nzt_listas_pizarra", schema = "kanban_db")
@Getter
@Setter
public class NztListasPizarra {
	
	@Id
	@Column(name = "id_lista_pizarra")
	private Long idListaPizarra;
	
	@Column(name = "ID_PIZARRA")
	private Long idPizarra;

	@Column(name = "txt_titulo")
	private String titulo;
	
	@Column(name = "txt_descripcion")
	private String descripcion;
	
	@Column(name = "num_posicion")
	private int posicion;
	
	@Column(name = "estatus")
	private int estatus;
	
	@Column(name = "id_usuario_crea")
	private Long idUsuarioCrea;
	
	@Column(name = "fch_creacion")
	private Date fchCreacion;
	
	@OneToMany(targetEntity = NztTareas.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_lista_pizarra", referencedColumnName = "ID_LISTA_PIZARRA" )
	private List<NztTareas> tareas;
	

}

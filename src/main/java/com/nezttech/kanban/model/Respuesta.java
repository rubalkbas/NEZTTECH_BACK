package com.nezttech.kanban.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Respuesta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/** Retorna el estatus de la peticion o codigo*/
	private String estatus;
	/** Retorna el mensaje de la peticion. */
	private String mensaje = "";
	/** Retorna un valor o cadena string */
	private String valor;
	/** retorna un codigo de error */
	private String codigoError;		
	/** Retorna una lista de DTOs */
	private transient  List<?> lista = null;
	/** Retorna un DTO */
	private transient  Object dto = null;
	
	/**
	 * @return the lista
	 */
	public List<?> getLista() {
	    List<?> tmp = null;
	    if(this.lista != null){
	        tmp = new ArrayList<>(this.lista);
	    }
	    
		return tmp;
	}

	/**
	 * @param lista
	 *            the lista to set
	 */
	public void setLista(List<?> tmp) {
	    if(tmp != null){
	        this.lista = new ArrayList<>(tmp);
	    }
	}

}

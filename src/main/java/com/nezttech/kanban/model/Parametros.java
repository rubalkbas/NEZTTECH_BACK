package com.nezttech.kanban.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

/**
 * @author NezTTech
 * @version 1.0
 * @since   2021-12-01
*/
@Getter
@Setter
public class Parametros implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String correo;

	@NotBlank
	private String pass;

}

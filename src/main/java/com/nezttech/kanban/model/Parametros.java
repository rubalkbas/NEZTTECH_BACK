package com.nezttech.kanban.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
    @Size(min = 3, max = 20)   
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String correo;
    
    /*private Set<String> role;*/
    
    @NotBlank
    @Size(min = 6, max = 40)    
    private String pass;
    
    
    private Long idPizarra;

}

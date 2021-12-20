package com.nezttech.kanban.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.nezttech.kanban.entity.NztUsuario;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author NezTTech
 * @version 1.0
 * @since   2021-12-01
*/
@Entity
@Table( name = "nzt_confirmacion_token", schema = "kanban_db" )
@Getter
@Setter
@NoArgsConstructor
public class ConfirmationToken implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="iID_TOKEN")
    private long tokenid;

    @Column(name="CONFIRMATION_TOKEN")
    private String confirmationToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToOne(targetEntity = NztUsuario.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "ID_USUARIO")
    private NztUsuario usuarios;

    public ConfirmationToken(NztUsuario usuarios) {
        this.usuarios = usuarios;
        createdDate = new Date();
        confirmationToken = UUID.randomUUID().toString();
    }

}

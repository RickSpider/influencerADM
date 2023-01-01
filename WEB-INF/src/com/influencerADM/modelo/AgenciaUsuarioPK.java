package com.influencerADM.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.doxacore.modelo.Usuario;

@Embeddable
public class AgenciaUsuarioPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 180832157930533621L;

	@ManyToOne
	@JoinColumn(name="usuarioid")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="agenciaid")
	private Agencia agencia;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	
}

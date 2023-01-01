package com.influencerADM.modelo;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.doxacore.modelo.Modelo;

@Entity
@Table(name = "AgenciasUsuarios")
public class AgenciaUsuario extends Modelo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7743047009075293084L;
	
	@EmbeddedId
	private AgenciaUsuarioPK agenciausuariopk;
	
	
	
	@Override
	public Object[] getArrayObjectDatos() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getStringDatos() {
		// TODO Auto-generated method stub
		return null;
	}
	public AgenciaUsuarioPK getAgenciausuariopk() {
		return agenciausuariopk;
	}
	public void setAgenciausuariopk(AgenciaUsuarioPK agenciausuariopk) {
		this.agenciausuariopk = agenciausuariopk;
	}
	
	
}

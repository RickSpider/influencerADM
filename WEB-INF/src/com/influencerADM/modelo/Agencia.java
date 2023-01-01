package com.influencerADM.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.doxacore.modelo.Modelo;

@Entity
@Table(name="Agencias")
public class Agencia extends Modelo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9083041458061344473L;
	
	@Id
	@Column(name ="agenciaid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long agenciaid;
	
	private String Agencia;
	
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
	public Long getAgenciaid() {
		return agenciaid;
	}
	public void setAgenciaid(Long agenciaid) {
		this.agenciaid = agenciaid;
	}
	public String getAgencia() {
		return Agencia;
	}
	public void setAgencia(String agencia) {
		Agencia = agencia;
	}
	
	
}

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
@Table(name =  "Clientes")
public class Cliente extends Modelo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7748546981410805336L;
	
	@Id
	@Column(name ="clienteid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long clienteid;
	private String razonSocial;
	private String ruc;
	
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
	public Long getClienteid() {
		return clienteid;
	}
	public void setClienteid(Long clienteid) {
		this.clienteid = clienteid;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	
	
}

package com.influencerADM.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.doxacore.modelo.Modelo;

@Entity
@Table(name = "RedesSociales")
public class RedSocial extends Modelo {

	@Id
	@Column(name ="redsocialid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long redsocialid;
	private String redSocial;
	
	
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
	
	public Long getRedsocialid() {
		return redsocialid;
	}
	public void setRedsocialid(Long redsocialid) {
		this.redsocialid = redsocialid;
	}
	public String getRedSocial() {
		return redSocial;
	}
	public void setRedSocial(String redSocial) {
		this.redSocial = redSocial;
	}
	
	
	
}

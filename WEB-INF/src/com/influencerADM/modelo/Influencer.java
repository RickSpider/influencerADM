package com.influencerADM.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.doxacore.modelo.Modelo;

@Entity
@Table(name = "Influencers")
public class Influencer extends Modelo {
	
	@Id
	@Column(name ="influencerid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long influencerid;
	
	private String nombre;
	private String apellido;



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

	public Long getInfluencerid() {
		return influencerid;
	}

	public void setInfluencerid(Long influencerid) {
		this.influencerid = influencerid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}

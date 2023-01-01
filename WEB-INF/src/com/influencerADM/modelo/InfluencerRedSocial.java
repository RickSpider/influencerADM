package com.influencerADM.modelo;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.doxacore.modelo.Modelo;

@Entity
@Table(name = "InfluencersRedesSociales")
public class InfluencerRedSocial extends Modelo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1550506801827119593L;

	@EmbeddedId
	private InfluencerRedSocialPK influencerredsocialpk;
	
	private long cantidadSeguidores;

	public long getCantidadSeguidores() {
		return cantidadSeguidores;
	}

	public void setCantidadSeguidores(long cantidadSeguidores) {
		this.cantidadSeguidores = cantidadSeguidores;
	}

	public InfluencerRedSocialPK getInfluencerredsocialpk() {
		return influencerredsocialpk;
	}

	public void setInfluencerredsocialpk(InfluencerRedSocialPK influencerredsocialpk) {
		this.influencerredsocialpk = influencerredsocialpk;
	}

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
	
	
}

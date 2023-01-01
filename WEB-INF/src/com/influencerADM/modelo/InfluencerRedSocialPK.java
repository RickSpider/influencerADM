package com.influencerADM.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.doxacore.modelo.Tipo;

@Embeddable
public class InfluencerRedSocialPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1979534488590414668L;

	@ManyToOne
	@JoinColumn(name="influencerid")
	private Influencer influencer;
	
	@ManyToOne
	@JoinColumn(name="redsocialid")
	private Tipo redSocial;
	
	private String perfil;

	public Influencer getInfluencer() {
		return influencer;
	}

	public void setInfluencer(Influencer influencer) {
		this.influencer = influencer;
	}

	public Tipo getRedSocial() {
		return redSocial;
	}

	public void setRedSocial(Tipo redSocial) {
		this.redSocial = redSocial;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	
	
	
	
}

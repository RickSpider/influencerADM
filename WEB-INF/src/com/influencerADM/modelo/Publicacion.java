package com.influencerADM.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.doxacore.modelo.Modelo;
import com.doxacore.modelo.Tipo;

@Entity
@Table(name = "Publicaciones")
public class Publicacion extends Modelo implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 8221316007628231451L;


	@Id
	@Column(name ="publicacionid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long publicacionid;
	
	@ManyToOne
	@JoinColumn(name="publicaciontipoid")
	private Tipo publicacionTipo;
	
	@ManyToOne
	@JoinColumn(name="influencerid")
	private Influencer influencer;
	
	
	@ManyToOne
	@JoinColumn(name="campanhaid")
	private Campanha campanha;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	
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
	public Long getPublicacionid() {
		return publicacionid;
	}
	public void setPublicacionid(Long publicacionid) {
		this.publicacionid = publicacionid;
	}
	public Tipo getPublicacionTipo() {
		return publicacionTipo;
	}
	public void setPublicacionTipo(Tipo publicacionTipo) {
		this.publicacionTipo = publicacionTipo;
	}
	public Influencer getInfluencer() {
		return influencer;
	}
	public void setInfluencer(Influencer influencer) {
		this.influencer = influencer;
	}
	public Campanha getCampanha() {
		return campanha;
	}
	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
		
}

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

@Entity
@Table(name = "Campanhas")
public class Campanha extends Modelo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 312944571425224808L;
	
	@Id
	@Column(name ="campanhaid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long campanhaid;
	private String campanha;
	
	@ManyToOne
	@JoinColumn(name="agenciaid")
	private Agencia agencia;
	
	@ManyToOne
	@JoinColumn(name="clienteid")
	private Cliente cliente;

	@Temporal(TemporalType.DATE)
	private Date fechaIni;
	
	@Temporal(TemporalType.DATE)
	private Date fechaFin;
	
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
	public Long getCampanhaid() {
		return campanhaid;
	}
	public void setCampanhaid(Long campanhaid) {
		this.campanhaid = campanhaid;
	}
	public String getCampanha() {
		return campanha;
	}
	public void setCampanha(String campanha) {
		this.campanha = campanha;
	}
	public Date getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Agencia getAgencia() {
		return agencia;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}

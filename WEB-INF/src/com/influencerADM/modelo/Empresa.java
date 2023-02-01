package com.influencerADM.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.doxacore.modelo.Modelo;

@Entity
@Table(name =  "Empresas")
public class Empresa extends Modelo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7748546981410805336L;
	
	@Id
	@Column(name ="empresaid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long empresaid;
	private String razonSocial;
	private String ruc;
	
	@ManyToMany
	@JoinTable(
	            name = "empresasagencias",
	            joinColumns = @JoinColumn(name = "empresaid"),
	            inverseJoinColumns = @JoinColumn(name = "agenciaid"))
	private List<Agencia> agencias;
	
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
	public Long getEmpresaid() {
		return empresaid;
	}
	public void setEmpresaid(Long empresaid) {
		this.empresaid = empresaid;
	}
	
	
}

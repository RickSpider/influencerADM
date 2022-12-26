package com.influencerADM.sistema.administracion;

import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Init;

import com.influencerADM.modelo.Influencer;
import com.influencerADM.util.ParamsLocal;
import com.influencerADM.util.TemplateViewModelLocal;


public class InfluencerVM extends TemplateViewModelLocal{

	
	private List<Influencer> lInfluencers;
	private List<Influencer> lInfluencersOri;
	private Influencer influencerSelected;

	private boolean opCrearInfluencer;
	private boolean opEditarInfluencer;
	private boolean opBorrarInfluencer;
	

	@Init(superclass = true)
	public void initInfluencerVM() {

		cargarInfluencers();
		inicializarFiltros();

	}

	@AfterCompose(superclass = true)
	public void afterComposeInfluencerVM() {

	}

	
	@Override
	protected void inicializarOperaciones() {
		
		this.opCrearInfluencer = this.operacionHabilitada(ParamsLocal.OP_CREAR_INFLUENCER);
		this.opEditarInfluencer = this.operacionHabilitada(ParamsLocal.OP_EDITAR_INFLUENCER);
		this.opBorrarInfluencer = this.operacionHabilitada(ParamsLocal.OP_BORRAR_INFLUENCER);
	
		
	}
	
	private void cargarInfluencers() {

		this.lInfluencers = this.reg.getAllObjectsByCondicionOrder(Influencer.class.getName(), null, "influencerid asc");
		this.lInfluencersOri = this.lInfluencers;
	}
	
	private String filtroColumns[];

	private void inicializarFiltros() {

		this.filtroColumns = new String[2]; // se debe de iniciar el filtro deacuerdo a la cantidad declarada en el
											// modelo sin id

		for (int i = 0; i < this.filtroColumns.length; i++) {

			this.filtroColumns[i] = "";

		}

	}

	public List<Influencer> getlInfluencers() {
		return lInfluencers;
	}

	public void setlInfluencers(List<Influencer> lInfluencers) {
		this.lInfluencers = lInfluencers;
	}

	public Influencer getInfluencerSelected() {
		return influencerSelected;
	}

	public void setInfluencerSelected(Influencer influencerSelected) {
		this.influencerSelected = influencerSelected;
	}

	public boolean isOpCrearInfluencer() {
		return opCrearInfluencer;
	}

	public void setOpCrearInfluencer(boolean opCrearInfluencer) {
		this.opCrearInfluencer = opCrearInfluencer;
	}

	public boolean isOpEditarInfluencer() {
		return opEditarInfluencer;
	}

	public void setOpEditarInfluencer(boolean opEditarInfluencer) {
		this.opEditarInfluencer = opEditarInfluencer;
	}

	public boolean isOpBorrarInfluencer() {
		return opBorrarInfluencer;
	}

	public void setOpBorrarInfluencer(boolean opBorrarInfluencer) {
		this.opBorrarInfluencer = opBorrarInfluencer;
	}

	public String[] getFiltroColumns() {
		return filtroColumns;
	}

	public void setFiltroColumns(String[] filtroColumns) {
		this.filtroColumns = filtroColumns;
	}

}

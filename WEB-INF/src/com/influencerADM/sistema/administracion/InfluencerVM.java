package com.influencerADM.sistema.administracion;

import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.util.Notification;
import org.zkoss.zul.Window;

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
	
	private boolean editar = false;

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
	
	//Seccion modal
	
	private Window modal;
	
	@Command
	public void modalInfluencerAgregar() {

		if(!this.isOpCrearInfluencer())
			return;

		this.editar = false;
		this.modalInfluencer(-1);

	}

	
	@Command
	public void modalInfluencer(@BindingParam("influencerid") long influencerid) {
		
		if (influencerid != -1) {
			
			if (!this.opEditarInfluencer)
				return;
			
			this.editar= true;
			this.influencerSelected = this.reg.getObjectById(Influencer.class.getName(), influencerid);
			
			
			
		}else {
			
			this.influencerSelected = new Influencer();
			
		}
		

		modal = (Window) Executions.createComponents("/sistema/zul/administracion/influencerModal.zul",
				this.mainComponent, null);
		Selectors.wireComponents(modal, this, false);
		modal.doModal();

	}
	
	@Command
	@NotifyChange("lInfluencers")
	public void guardar() {
		
		this.save(this.influencerSelected);
		
		this.influencerSelected = null;

		this.cargarInfluencers();

		this.modal.detach();
		
		if (editar) {
			
			Notification.show("Influencer Actualizado.");
			this.editar = false;
		}else {
			
			Notification.show("El Influencer fue agregado.");
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

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}
	
	

}

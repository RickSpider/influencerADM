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

import com.influencerADM.modelo.Agencia;
import com.influencerADM.util.ParamsLocal;
import com.influencerADM.util.TemplateViewModelLocal;




public class AgenciaVM extends TemplateViewModelLocal{

	
	private List<Agencia> lAgencias;
	private List<Agencia> lAgenciasOri;
	private Agencia agenciaSelected;

	private boolean opCrearAgencia;
	private boolean opEditarAgencia;
	private boolean opBorrarAgencia;
	
	private boolean editar = false;

	@Init(superclass = true)
	public void initAgenciaVM() {

		cargarAgencias();
		inicializarFiltros();

	}

	@AfterCompose(superclass = true)
	public void afterComposeAgenciaVM() {

	}

	
	@Override
	protected void inicializarOperaciones() {
		
		this.opCrearAgencia = this.operacionHabilitada(ParamsLocal.OP_CREAR_AGENCIA);
		this.opEditarAgencia = this.operacionHabilitada(ParamsLocal.OP_EDITAR_AGENCIA);
		this.opBorrarAgencia = this.operacionHabilitada(ParamsLocal.OP_BORRAR_AGENCIA);
	
		
	}
	
	private void cargarAgencias() {

		this.lAgencias = this.reg.getAllObjectsByCondicionOrder(Agencia.class.getName(), null, "agenciaid asc");
		this.lAgenciasOri = this.lAgencias;
	}
	
	private String filtroColumns[];

	private void inicializarFiltros() {

		this.filtroColumns = new String[1]; // se debe de iniciar el filtro deacuerdo a la cantidad declarada en el
											// modelo sin id

		for (int i = 0; i < this.filtroColumns.length; i++) {

			this.filtroColumns[i] = "";

		}

	}
	
	//Seccion modal
	
	private Window modal;
	
	@Command
	public void modalAgenciaAgregar() {

		if(!this.isOpCrearAgencia())
			return;

		this.editar = false;
		this.modalAgencia(-1);

	}

	
	@Command
	public void modalAgencia(@BindingParam("agenciaid") long agenciaid) {
		
		if (agenciaid != -1) {
			
			if (!this.opEditarAgencia)
				return;
			
			this.editar= true;
			this.agenciaSelected = this.reg.getObjectById(Agencia.class.getName(), agenciaid);
			
			
			
		}else {
			
			this.agenciaSelected = new Agencia();
			
		}
		

		modal = (Window) Executions.createComponents("/sistema/zul/administracion/agenciaModal.zul",
				this.mainComponent, null);
		Selectors.wireComponents(modal, this, false);
		modal.doModal();

	}
	
	@Command
	@NotifyChange("lAgencias")
	public void guardar() {
		
		this.save(this.agenciaSelected);
		
		this.agenciaSelected = null;

		this.cargarAgencias();

		this.modal.detach();
		
		if (editar) {
			
			Notification.show("Agencia Actualizado.");
			this.editar = false;
		}else {
			
			Notification.show("El Agencia fue agregado.");
		}
		
	}
	

	public List<Agencia> getlAgencias() {
		return lAgencias;
	}

	public void setlAgencias(List<Agencia> lAgencias) {
		this.lAgencias = lAgencias;
	}

	public Agencia getAgenciaSelected() {
		return agenciaSelected;
	}

	public void setAgenciaSelected(Agencia agenciaSelected) {
		this.agenciaSelected = agenciaSelected;
	}

	public boolean isOpCrearAgencia() {
		return opCrearAgencia;
	}

	public void setOpCrearAgencia(boolean opCrearAgencia) {
		this.opCrearAgencia = opCrearAgencia;
	}

	public boolean isOpEditarAgencia() {
		return opEditarAgencia;
	}

	public void setOpEditarAgencia(boolean opEditarAgencia) {
		this.opEditarAgencia = opEditarAgencia;
	}

	public boolean isOpBorrarAgencia() {
		return opBorrarAgencia;
	}

	public void setOpBorrarAgencia(boolean opBorrarAgencia) {
		this.opBorrarAgencia = opBorrarAgencia;
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

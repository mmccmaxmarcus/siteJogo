package br.com.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import br.com.models.GeneroModel;
import br.com.models.PlataformaModel;
import entities.Genero;
import entities.Plataforma;

@SuppressWarnings("serial")
@ManagedBean(name = "plataformaBeanBeta")
@RequestScoped
public class PlataformaBean implements Serializable {
	private List<String> generosPC;
	private List<Plataforma> plataformas;
	private Plataforma adicionaPlataforma;
	
	
	public Plataforma getAdicionaPlataforma() {
		return adicionaPlataforma;
	}
	
	public void setAdicionaPlataforma(Plataforma adicionaPlataforma) {
		this.adicionaPlataforma = adicionaPlataforma;
	}
	
	

	private PlataformaModel getPlataformaModel() {
		PlataformaModel plataformaModel = new PlataformaModel();
		return plataformaModel;
	}

	public List<String> getGenerosPC() {
		return generosPC;
	}

	@PostConstruct
	public void list() {
		this.generosPC = new ArrayList<>();
		try {
			this.generosPC = getPlataformaModel().buscarPorGenero(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}

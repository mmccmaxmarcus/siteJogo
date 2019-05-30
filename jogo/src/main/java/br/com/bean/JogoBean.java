package br.com.bean;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.models.ImagemModel;
import br.com.models.JogoModel;
import entities.Imagem;
import entities.Jogo;

@SuppressWarnings("serial")
@ManagedBean(name = "jogoBean")
@SessionScoped
public class JogoBean implements Serializable {
	private List<Jogo> jogos;
	private Imagem imagem;
	private Jogo jogo;

	public Jogo getJogo() {
		return jogo;
	}

	private JogoModel getJogoModel() {
		JogoModel jogoModel = new JogoModel();
		return jogoModel;
	}

	private ImagemModel getImagemModel() {
		ImagemModel imagemModel = new ImagemModel();
		return imagemModel;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	@PostConstruct
	public void list() {
		try {
			this.jogos = getJogoModel().list();
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao listar");
		}
	}

	public StreamedContent getConteudoImage() {
		String imagemID = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("jogoImagem");
		this.imagem = new Imagem();

		try {
			this.imagem = getImagemModel().find(Integer.parseInt(imagemID));
			System.out.println(this.imagem.getId());
			InputStream is = new ByteArrayInputStream(this.imagem.getImagemJogo());
			DefaultStreamedContent streamedContent = new DefaultStreamedContent(is);
			return streamedContent;
		} catch (Exception e) {
			return new DefaultStreamedContent();
		}

	}

	public void mostraJogo(ActionEvent event) {
		this.jogo = new Jogo();
		try {
			this.jogo = (Jogo) event.getComponent().getAttributes().get("jogoSelecionado");
			System.out.println(this.jogo.getEspecificacao().getMemoriaRam());
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

}

package br.com.bean;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.models.GeneroModel;
import br.com.models.ImagemModel;
import br.com.models.JogoModel;
import br.com.models.ScreenshotModel;
import entities.Especificacao;
import entities.Genero;
import entities.Imagem;
import entities.Jogo;
import entities.Screenshot;

@SuppressWarnings("serial")
@ManagedBean(name = "jogoBean")
@SessionScoped
public class JogoBean implements Serializable {
	private List<Jogo> jogos;
	private Imagem imagem;
	private Jogo jogo;
	private List<Genero> generos;
	private List<Jogo> jogosSelecionadosOuNao;
	private Jogo adicionaJogo;


	public Jogo getAdicionaJogo() {
		return adicionaJogo;
	}

	public void setAdicionaJogo(Jogo adicionaJogo) {
		this.adicionaJogo = adicionaJogo;
	}

	public List<Jogo> getJogosSelecionadosOuNao() {
		return jogosSelecionadosOuNao;
	}

	public void setJogosSelecionadosOuNao(List<Jogo> jogosSelecionadosOuNao) {
		this.jogosSelecionadosOuNao = jogosSelecionadosOuNao;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	private GeneroModel getGeneroModel() {
		GeneroModel generoModel = new GeneroModel();
		return generoModel;
	}

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

	private ScreenshotModel getScreeshotModel() {
		ScreenshotModel screenshotModel = new ScreenshotModel();
		return screenshotModel;
	}

	public List<Jogo> getJogos() {
		return jogos;
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

	public StreamedContent getScreenImage() {
		String screenID = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("screenImagem");

		try {
			Screenshot screenshot = getScreeshotModel().find(Integer.parseInt(screenID));
			System.out.println(screenshot.getId());
			InputStream is = new ByteArrayInputStream(screenshot.getImagemScreenshot());
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
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	public void recebeGeneroParaListagem(ActionEvent event) {
		try {
			String genero = null;
			genero = (String) event.getComponent().getAttributes().get("item");

			if (genero.isEmpty() || genero.equals(null)) {
				genero = null;
				list();
			} else {
				list(genero);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

	}

	@PostConstruct
	public void list() {
		this.jogosSelecionadosOuNao = new ArrayList<>();
		this.jogos = new ArrayList<>();
		try {
			this.jogos = getJogoModel().list();
			for (Jogo j : this.jogos) {
				this.jogosSelecionadosOuNao.add(j);

			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	public void list(String genero) {
		this.generos = new ArrayList<>();
		this.jogosSelecionadosOuNao = new ArrayList<>();
		try {
			this.generos = getGeneroModel().contains(genero, "tipoGenero.tipoGenero");

			for (Genero g : this.generos) {
				this.jogosSelecionadosOuNao.add(g.getJogo());
			}

			for (Jogo jogo : this.jogosSelecionadosOuNao) {
				System.out.println(jogo.getTituloJogo());
			}
		} catch (RuntimeException e) {
			e.printStackTrace();

		}
	}

}

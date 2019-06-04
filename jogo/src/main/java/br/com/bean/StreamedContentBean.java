package br.com.bean;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.models.ImagemModel;
import entities.Imagem;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class StreamedContentBean implements Serializable{

	private Imagem imagem;
	private String conteudoImagem;

	public StreamedContentBean(String conteudoImagem) {
		super();
		this.imagem = new Imagem();
		this.conteudoImagem = conteudoImagem;
	}

	private ImagemModel getImagemModel() {
		ImagemModel imagemModel = new ImagemModel();
		return imagemModel;
	}
	
	public void setConteudoImagem(String conteudoImagem) {
		this.conteudoImagem = conteudoImagem;
	}
	
	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}
	
	public Imagem getImagem() {
		return imagem;
	}

	public StreamedContent getConteudoImage() {
		String imagemID = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get(conteudoImagem);

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

}

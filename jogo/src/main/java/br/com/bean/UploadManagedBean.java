package br.com.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.omnifaces.util.Messages;
import org.primefaces.model.UploadedFile;

import br.com.models.ImagemModel;
import entities.Imagem;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean(name = "uploadManagedBean")
public class UploadManagedBean implements Serializable {
	private UploadedFile uploadedFile;
	private Imagem imagem;

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	private ImagemModel getImagemModel() {
		ImagemModel imagemModel = new ImagemModel();
		return imagemModel;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

	public void upload() {
		this.imagem = new Imagem();
		this.imagem.setImagemJogo(uploadedFile.getContents());
		this.imagem.setNomeArquivo(uploadedFile.getFileName());
		try {
			getImagemModel().save(this.imagem);
			Messages.addGlobalInfo("Upload salvo com sucesso");

		} catch (Exception e) {
			Messages.addGlobalError("Erro ao fazer upload");
			e.printStackTrace();
		}

	}

}

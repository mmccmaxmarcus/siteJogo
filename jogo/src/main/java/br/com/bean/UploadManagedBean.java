package br.com.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Messages;
import org.primefaces.model.UploadedFile;

import br.com.models.ImagemModel;
import br.com.models.ScreenshotModel;
import entities.Imagem;
import entities.Screenshot;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean(name = "uploadManagedBean")
public class UploadManagedBean implements Serializable {
	private UploadedFile uploadedFile;
	private Imagem imagem;
	private Screenshot screenshot;
	private List<Imagem> imagens;

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public List<Imagem> getImagens() {
		return imagens;
	}

	public Screenshot getScreenshot() {
		if (this.screenshot == null) {
			this.screenshot = new Screenshot();
		}
		return screenshot;
	}

	public void setScreenshot(Screenshot screenshot) {
		this.screenshot = screenshot;
	}

	private ScreenshotModel getScreenshotModel() {
		ScreenshotModel screenshotModel = new ScreenshotModel();
		return screenshotModel;
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

	public void uploadImagem() {
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
    
	@PostConstruct
	public void ListImagem() {
		this.imagens = new ArrayList<>();
		try {
			this.imagens = getImagemModel().list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	

	public void uploadScreenshot() {
		this.screenshot = new Screenshot();
		try {
			this.screenshot.setImagemScreenshot(uploadedFile.getContents());
			this.screenshot.setNomeArquivoScreenshot(uploadedFile.getFileName());
			getScreenshotModel().save(screenshot);
			Messages.addGlobalInfo("Upload salvo com sucesso");
		} catch (RuntimeException e) {
		    e.printStackTrace();
		}
		
	}

}

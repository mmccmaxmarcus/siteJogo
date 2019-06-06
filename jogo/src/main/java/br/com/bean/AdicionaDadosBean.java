package br.com.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.UploadedFile;

import br.com.models.ImagemModel;
import br.com.models.JogoModel;
import br.com.models.PlataformaModel;
import entities.Especificacao;
import entities.Imagem;
import entities.Jogo;
import entities.Plataforma;
import entities.Screenshot;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class AdicionaDadosBean implements Serializable {
	private Especificacao especificacao;
	private Plataforma plataforma;
	private boolean skip;
	private Jogo jogo;
	private Screenshot screenshot;

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public boolean getSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	private Imagem imagem;

	public Especificacao getEspecificacao() {
		if (this.especificacao == null) {
			this.especificacao = new Especificacao();
		}
		return especificacao;
	}

	public void setEspecificacao(Especificacao especificacao) {
		this.especificacao = especificacao;
	}

	public Plataforma getPlataforma() {
		if (this.plataforma == null) {
			this.plataforma = new Plataforma();
		}
		return plataforma;
	}

	private PlataformaModel getPlataformaModel() {
		PlataformaModel plataformaModel = new PlataformaModel();
		return plataformaModel;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

	public Imagem getImagem() {
		return imagem;
	}

	private JogoModel getJogoModel() {
		JogoModel jogoModel = new JogoModel();
		return jogoModel;
	}

	private ImagemModel getImagemModel() {
		ImagemModel imagemModel = new ImagemModel();
		return imagemModel;
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false;
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	public void salvarPlataforma() {
		try {
			getPlataformaModel().save(plataforma);
			this.plataforma = new Plataforma();
			Messages.addGlobalInfo("Plataforma salvo com sucesso");
		} catch (RuntimeException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public void uploadImagem(FileUploadEvent uploadEvent) {
		this.imagem = new Imagem();
		try {
			UploadedFile uploadedFile = uploadEvent.getFile();
			this.imagem.setImagemJogo(uploadedFile.getContents());
			this.imagem.setNomeArquivo(uploadedFile.getFileName());
			getImagemModel().save(imagem);
			Messages.addGlobalInfo("Imagem salva com sucesso");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

}

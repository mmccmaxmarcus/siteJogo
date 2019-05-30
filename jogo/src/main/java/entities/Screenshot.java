package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "SCREENSHORT")
public class Screenshot implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Integer id;

	@ManyToOne
	@JoinColumn(nullable = true, name = "imagem_id")
	private Imagem imagem;

	@Column(nullable = false)
	@Lob
	private byte[] imagemScreenshot;

	@Column(nullable = true, name = "nomeArquivo", length = 50)
	private String nomeArquivoScreenshot;

	public Screenshot() {

	}

	public Screenshot(Imagem imagem, byte[] imagemScreenshot, String nomeArquivoScreenshot) {
		super();
		this.imagem = imagem;
		this.imagemScreenshot = imagemScreenshot;
		this.nomeArquivoScreenshot = nomeArquivoScreenshot;
	}

	public Screenshot(byte[] imagemScreenshot, String nomeArquivoScreenshot) {
		super();
		this.imagemScreenshot = imagemScreenshot;
		this.nomeArquivoScreenshot = nomeArquivoScreenshot;
	}

	public Integer getId() {
		return id;
	}

	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

	public byte[] getImagemScreenshot() {
		return imagemScreenshot;
	}

	public void setImagemScreenshot(byte[] imagemScreenshot) {
		this.imagemScreenshot = imagemScreenshot;
	}

	public String getNomeArquivoScreenshot() {
		return nomeArquivoScreenshot;
	}

	public void setNomeArquivoScreenshot(String nomeArquivoScreenshot) {
		this.nomeArquivoScreenshot = nomeArquivoScreenshot;
	}

}

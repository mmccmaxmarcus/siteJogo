package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "IMAGEM")
public class Imagem implements Serializable {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(nullable = false, unique = true)
	private int id;

	@Column(nullable = false)
	@Lob
	private byte[] imagemJogo;

	@Column(nullable = true, length = 250)
	private String nomeArquivo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "imagem", cascade = CascadeType.ALL)
	private List<Screenshot> screenshorts;

	public Imagem() {

	}

	public Imagem(byte[] imagemJogo, String nomeArquivo) {
		this.imagemJogo = imagemJogo;
		this.nomeArquivo = nomeArquivo;
	}

	public byte[] getImagemJogo() {
		return imagemJogo;
	}

	public void setImagemJogo(byte[] imagemJogo) {
		this.imagemJogo = imagemJogo;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public int getId() {
		return id;
	}

	public List<Screenshot> getScreenshorts() {
		return screenshorts;
	}

	public void setScreenshorts(List<Screenshot> screenshorts) {
		this.screenshorts = screenshorts;
	}
	
	

}

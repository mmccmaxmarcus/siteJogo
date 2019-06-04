package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name = "JOGO")
public class Jogo implements Serializable {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(nullable = false, unique = true)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataDeLançamento;

	@Column(nullable = false, length = 50)
	private String tamanhoJogo;

	@OneToOne
	@JoinColumn(nullable = false, unique = true, name = "imagem_id")
	private Imagem imagem;

	@OneToOne
	@JoinColumn(nullable = false, unique = true, name = "especificacao_id")
	private Especificacao especificacao;

	@Column(nullable = false, length = 10)
	// Se é ISO, ou Cue
	private String formatoJogo;

	@Column(nullable = false)
	private Boolean crackIncluso;

	@Column(nullable = false, length = 250)
	private String tituloJogo;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataADDDoJogo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jogo", cascade = CascadeType.ALL)
	private List<Genero> generos;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jogo", cascade = CascadeType.ALL)
	private List<Idioma> idiomas;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jogo", cascade = CascadeType.ALL)
	private List<Screenshot> screenshots;

	@Column(length = 20000, nullable = false)
	private String sinopse;

	@ManyToOne
	@JoinColumn(nullable = false, name = "plataforma_id")
	private Plataforma plataforma;

	@Transient
	public String crackFormatado() {
		String crack = null;
		if (this.crackIncluso.equals(true)) {
			crack = "INCLUSO";
		} else {
			crack = "NÃO INCLUSO";
		}

		return crack;
	}

	public Jogo() {

	}

	public Jogo(Date dataDeLançamento, String tamanhoJogo, Imagem imagem, String formatoJogo, Boolean crackIncluso,
			String tituloJogo, Plataforma plataforma, Date dataADDDoJogo, String sinopse) {
		super();
		this.plataforma = plataforma;
		this.dataDeLançamento = dataDeLançamento;
		this.tamanhoJogo = tamanhoJogo;
		this.imagem = imagem;
		this.formatoJogo = formatoJogo;
		this.crackIncluso = crackIncluso;
		this.tituloJogo = tituloJogo;
		this.dataADDDoJogo = dataADDDoJogo;
		this.sinopse = sinopse;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataDeLançamento() {
		return dataDeLançamento;
	}

	public void setDataDeLançamento(Date dataDeLançamento) {
		this.dataDeLançamento = dataDeLançamento;
	}

	public String getTamanhoJogo() {
		return tamanhoJogo;
	}

	public void setTamanhoJogo(String tamanhoJogo) {
		this.tamanhoJogo = tamanhoJogo;
	}

	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

	public String getFormatoJogo() {
		return formatoJogo;
	}

	public void setFormatoJogo(String formatoJogo) {
		this.formatoJogo = formatoJogo;
	}

	public Boolean getCrackIncluso() {
		return crackIncluso;
	}

	public void setCrackIncluso(Boolean crackIncluso) {
		this.crackIncluso = crackIncluso;
	}

	public String getTituloJogo() {
		return tituloJogo;
	}

	public void setTituloJogo(String tituloJogo) {
		this.tituloJogo = tituloJogo;
	}

	public Date getDataADDDoJogo() {
		return dataADDDoJogo;
	}

	public void setDataADDDoJogo(Date dataADDDoJogo) {
		this.dataADDDoJogo = dataADDDoJogo;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

	public List<Idioma> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Especificacao getEspecificacao() {
		return especificacao;
	}

	public void setEspecificacao(Especificacao especificacao) {
		this.especificacao = especificacao;
	}

	public List<Screenshot> getScreenshots() {
		return screenshots;
	}

	public void setScreenshots(List<Screenshot> screenshots) {
		this.screenshots = screenshots;
	}

}

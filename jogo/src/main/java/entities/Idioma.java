package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "IDIOMA")
public class Idioma implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Integer id;

	@Column(length = 200, nullable = false)
	private String nomeIdioma;

	@Column(nullable = true, length = 10)
	private String siglaIdioma;
	
	@ManyToOne
	@JoinColumn(nullable = true, name = "jogo_id")
	private Jogo jogo;

	public Idioma() {
		// TODO Auto-generated constructor stub
	}

	public Idioma(String nomeIdioma, String siglaIdioma, Jogo jogo) {
		super();
		this.nomeIdioma = nomeIdioma;
		this.siglaIdioma = siglaIdioma;
		this.jogo = jogo;
	}

	public String getNomeIdioma() {
		return nomeIdioma;
	}

	public void setNomeIdioma(String nomeIdioma) {
		this.nomeIdioma = nomeIdioma;
	}

	public String getSiglaIdioma() {
		return siglaIdioma;
	}

	public void setSiglaIdioma(String siglaIdioma) {
		this.siglaIdioma = siglaIdioma;
	}

}

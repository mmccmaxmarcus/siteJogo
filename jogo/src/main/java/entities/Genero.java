package entities;

import java.io.Serializable;
import java.util.spi.TimeZoneNameProvider;

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
@Table(name = "GENERO")
public class Genero implements Serializable {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	
	@ManyToOne
	@JoinColumn(nullable = true, name = "jogo_id")
	private Jogo jogo;

	@ManyToOne
	@JoinColumn(nullable = false, name = "plataforma_id")
	private Plataforma plataforma;
	
	@ManyToOne
	@JoinColumn(nullable=false, name="generoTipo_id")
	private GeneroTipo tipoGenero;

	public Genero() {
		// TODO Auto-generated constructor stub
	}

	public Genero(Jogo jogo, Plataforma plataforma, GeneroTipo tipoGenero) {
		this.jogo = jogo;
		this.plataforma = plataforma;
		this.tipoGenero = tipoGenero;
	}



	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Integer getId() {
		return id;
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public GeneroTipo getTipoGenero() {
		return tipoGenero;
	}
	
	public void setTipoGenero(GeneroTipo tipoGenero) {
		this.tipoGenero = tipoGenero;
	}

	

}

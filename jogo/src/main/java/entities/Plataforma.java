package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "PLATAFORMA")
public class Plataforma implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(length = 50, nullable = false)
	private String tipoPlataforma;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "plataforma", cascade = CascadeType.ALL)
	private List<Genero> generos;

	public Plataforma() {
		// TODO Auto-generated constructor stub
	}

	public Plataforma(String tipoPlataforma) {
		this.tipoPlataforma = tipoPlataforma;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoPlataforma() {
		return tipoPlataforma;
	}

	public void setTipoPlataforma(String tipoPlataforma) {
		this.tipoPlataforma = tipoPlataforma;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

}

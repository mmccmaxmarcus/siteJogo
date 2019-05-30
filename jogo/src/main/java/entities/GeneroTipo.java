package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "GENERIDOTIPO")
public class GeneroTipo implements Serializable {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(nullable = false, unique = true)
	private Integer id;

	@Column(unique = true, nullable = false, length = 100)
	private String tipoGenero;

	public GeneroTipo() {

	}

	public GeneroTipo(String tipoGenero) {
		this.tipoGenero = tipoGenero;
	}

	public String getTipoGenero() {
		return tipoGenero;
	}

	public void setTipoGenero(String tipoGenero) {
		this.tipoGenero = tipoGenero;
	}

}

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
@Table(name = "ESPECIFICACAO")
public class Especificacao implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Integer id;

	@Column(nullable = true, length = 50)
	private String sistemaOperacional;

	@Column(nullable = true, length = 75)
	private String processador;

	@Column(nullable = true, length = 100)
	private String memoriaRam;

	@Column(nullable = true, length = 75)
	private String placaDeVideo;

	@Column(nullable = true, length = 50)
	private String directx;

	@Column(nullable = true, length = 75)
	private String armazenamentoHD;

	@Column(nullable = true, length = 50)
	private String placaDeSom;

	@Column(nullable = true, length = 100)
	private String observacoes;

	public Especificacao() {

	}

	public Especificacao(String sistemaOperacional, String processador, String memoriaRam, String placaDeVideo,
			String directx, String armazenamentoHD, String placaDeSom) {
		super();
		this.sistemaOperacional = sistemaOperacional;
		this.processador = processador;
		this.memoriaRam = memoriaRam;
		this.placaDeVideo = placaDeVideo;
		this.directx = directx;
		this.armazenamentoHD = armazenamentoHD;
		this.placaDeSom = placaDeSom;
	}

	public Especificacao(String sistemaOperacional, String processador, String memoriaRam, String placaDeVideo,
			String directx, String armazenamentoHD, String placaDeSom, String observacoes) {
		super();
		this.sistemaOperacional = sistemaOperacional;
		this.processador = processador;
		this.memoriaRam = memoriaRam;
		this.placaDeVideo = placaDeVideo;
		this.directx = directx;
		this.armazenamentoHD = armazenamentoHD;
		this.placaDeSom = placaDeSom;
		this.observacoes = observacoes;
	}

	public Integer getId() {
		return id;
	}

	public String getSistemaOperacional() {
		return sistemaOperacional;
	}

	public void setSistemaOperacional(String sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public String getMemoriaRam() {
		return memoriaRam;
	}

	public void setMemoriaRam(String memoriaRam) {
		this.memoriaRam = memoriaRam;
	}

	public String getPlacaDeVideo() {
		return placaDeVideo;
	}

	public void setPlacaDeVideo(String placaDeVideo) {
		this.placaDeVideo = placaDeVideo;
	}

	public String getDirectx() {
		return directx;
	}

	public void setDirectx(String directx) {
		this.directx = directx;
	}

	public String getArmazenamentoHD() {
		return armazenamentoHD;
	}

	public void setArmazenamentoHD(String armazenamentoHD) {
		this.armazenamentoHD = armazenamentoHD;
	}

	public String getPlacaDeSom() {
		return placaDeSom;
	}

	public void setPlacaDeSom(String placaDeSom) {
		this.placaDeSom = placaDeSom;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

}

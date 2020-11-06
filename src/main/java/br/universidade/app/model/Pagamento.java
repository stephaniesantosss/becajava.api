package br.universidade.app.model;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pagamento {
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String Referencia;
	private double Valor;
		
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getReferencia() {
		return Referencia;
	}
	public void setReferencia(String referencia) {
		Referencia = referencia;
	}
	public double getValor() {
		return Valor;
	}
	public void setValor(double valor) {
		Valor = valor;
	}
	
	@ManyToOne
	@JoinColumn(name = "CursoId")
	private Curso curso;


	
}

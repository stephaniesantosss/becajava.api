
package br.universidade.app.model;

import javax.persistence.*;

@Entity
public class Curso {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String Nome;
	private String Periodo;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getPeriodo() {
		return Periodo;
	}

	public void setPeriodo(String periodo) {
		Periodo = periodo;
	}

}

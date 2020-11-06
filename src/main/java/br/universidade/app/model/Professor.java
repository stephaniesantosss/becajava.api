
package br.universidade.app.model;

import javax.persistence.*;

@Entity
public class Professor {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String Nome;
	private String CPF;

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

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

}

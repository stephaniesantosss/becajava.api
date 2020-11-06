
package br.universidade.app.model;

import javax.persistence.*;

@Entity
public class Disciplina {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String Nome;
	@ManyToOne

	@JoinColumn(name = "ProfessorId")
	private Professor Professor;

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

}
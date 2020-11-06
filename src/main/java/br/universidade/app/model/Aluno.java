
package br.universidade.app.model;

import javax.persistence.*;

@Entity
public class Aluno {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String Nome;
	private String RA;
	private String DataNascimento;
	
	@ManyToOne
	@JoinColumn(name = "CursoId")
	private Curso Curso;

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

	public String getRA() {
		return RA;
	}

	public void setRA(String rA) {
		RA = rA;
	}

	public String getDataNascimento() {
		return DataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		DataNascimento = dataNascimento;
	}
}
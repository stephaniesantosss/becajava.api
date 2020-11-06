
package br.universidade.app.model;

import javax.persistence.*;

@Entity
public class Nota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private Double Nota;
	@ManyToOne

	@JoinColumn(name = "AlunoId")
	private Aluno aluno;

	@ManyToOne

	@JoinColumn(name = "DisciplinaId")
	private Disciplina disciplina;

	public Double getNota() {
		return Nota;
	}

	public void setNota(Double nota) {
		Nota = nota;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	
}
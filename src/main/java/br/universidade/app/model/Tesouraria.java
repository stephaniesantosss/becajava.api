package br.universidade.app.model;

import java.util.Optional;

import javax.persistence.*;

@Entity
public class Tesouraria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String Responsavel;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getResponsavel() {
		return Responsavel;
	}
	public void setResponsavel(String responsavel) {
		Responsavel = responsavel;
	}
	@ManyToOne
	@JoinColumn(name = "PagamentoId")
	private Pagamento pagamento;
	
}

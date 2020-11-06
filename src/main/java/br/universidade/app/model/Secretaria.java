package br.universidade.app.model;

import javax.persistence.*;

@Entity
public class Secretaria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "PagamentoId")
	private Pagamento pagamento;
	
}

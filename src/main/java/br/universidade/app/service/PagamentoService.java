package br.universidade.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.universidade.app.model.Pagamento;
import br.universidade.app.repository.PagamentoRepository;


@Service
public class PagamentoService {
	
	final PagamentoRepository _repository;
	
	@Autowired
	public PagamentoService(PagamentoRepository repository) {
		_repository = repository;
	}	
	
	public void inserir(Pagamento pagamento) {
		pagamento.setId(new Long(0));
		_repository.save(pagamento);		
	}
	
	public void excluir (Long Id) {
		_repository.deleteById(Id);
	}
		
	public void atualizar (Long Id, Pagamento pagamento) {
		pagamento.setId(Id);
		_repository.save(pagamento);
	}
	
	public List<Pagamento> listar(){	
		return _repository.findAll();
	}
	
	public Optional<Pagamento> listarUm(Long Id){	
		return _repository.findById(Id);
	}
	
}

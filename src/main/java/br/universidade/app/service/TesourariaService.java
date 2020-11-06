package br.universidade.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.universidade.app.model.Tesouraria;
import br.universidade.app.repository.TesourariaRepository;

@Service
public class TesourariaService  {
	
	final TesourariaRepository _repository;
	
	@Autowired
	public TesourariaService(TesourariaRepository repository) {
		_repository = repository;
	}	
	
	public void inserir(Tesouraria tesouraria) {
		tesouraria.setId(new Long(0));
		_repository.save(tesouraria);		
	}
	
	public void excluir (Long Id) {
		_repository.deleteById(Id);
	}
		
	public void atualizar (Long Id, Tesouraria tesouraria) {
		tesouraria.setId(Id);
		_repository.save(tesouraria);
	}
	
	public List<Tesouraria> listar(){	
		return _repository.findAll();
	}
	
	public Optional<Tesouraria> listarUm(Long Id){	
		return _repository.findById(Id);
	}
	
}

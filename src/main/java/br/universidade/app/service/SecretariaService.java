package br.universidade.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.universidade.app.model.Secretaria;
import br.universidade.app.repository.SecretariaRepository;

@Service
public class SecretariaService  {
	
	final SecretariaRepository _repository;
	
	@Autowired
	public SecretariaService(SecretariaRepository repository) {
		_repository = repository;
	}	
	
	public void inserir(Secretaria tesouraria) {
		tesouraria.setId(new Long(0));
		_repository.save(tesouraria);		
	}
	
	public void excluir (Long Id) {
		_repository.deleteById(Id);
	}
		
	public void atualizar (Long Id, Secretaria tesouraria) {
		tesouraria.setId(Id);
		_repository.save(tesouraria);
	}
	
	public List<Secretaria> listar(){	
		return _repository.findAll();
	}
	
	public Optional<Secretaria> listarUm(Long Id){	
		return _repository.findById(Id);
	}
	
}

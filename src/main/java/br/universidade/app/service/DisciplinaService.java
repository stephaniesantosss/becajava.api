package br.universidade.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.universidade.app.model.Curso;
import br.universidade.app.model.Disciplina;
import br.universidade.app.repository.DisciplinaRepository;

@Service
public class DisciplinaService {
	
	final DisciplinaRepository _repository;
	
	@Autowired
	public DisciplinaService(DisciplinaRepository repository) {
		_repository = repository;
	}	
	
	public void inserir(Disciplina disciplina) {
		disciplina.setId(new Long(0));
		_repository.save(disciplina);		
	}
	 
	public void atualizar (Long Id, Disciplina disciplina) {
		disciplina.setId(Id);	
		_repository.save(disciplina);
	}
	
	public List<Disciplina> listar(){	
		return _repository.findAll();
	}

	public Optional<Disciplina> listarUm(Long id) {
		return null;
	}

	public void excluir (long Id) {
		_repository.deleteById(Id);
	}

	
	

}

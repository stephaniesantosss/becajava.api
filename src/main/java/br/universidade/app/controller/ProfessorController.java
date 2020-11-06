package br.universidade.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.universidade.app.model.Nota;
import br.universidade.app.model.Professor;
import br.universidade.app.repository.ProfessorRepository;
import br.universidade.app.service.ProfessorService;

@RestController

@RequestMapping("/professores")
public class ProfessorController {
	
private final ProfessorService _service;
	
	@Autowired
	public ProfessorController(ProfessorService service) {
		_service = service;
	}
	
	@PostMapping
    public ResponseEntity inserir(@RequestBody Professor professor) {
        try {
            _service.inserir(professor);
            return ResponseEntity.status(HttpStatus.CREATED).body("professor inserido com sucesso!");
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Não foi possível o cadastro do professor!");
        }
    }

    @GetMapping
    public ResponseEntity listar() {
        try {
            Iterable<Professor> professores = _service.listar();
            return ResponseEntity.status(HttpStatus.OK).body(professores);
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Não existe nenhum professor!");
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity listarUm(@PathVariable Long id) {
        try {
            Optional<Professor> professor = _service.listarUm(id);
            return ResponseEntity.status(HttpStatus.OK).body(professor);
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.CREATED).body("professor não existe!");
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Professor professor) {
        try {
            _service.atualizar(id, professor);
            return ResponseEntity.status(HttpStatus.OK).body("professor atualizado com sucesso!!!");
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Não foi possível a atualização!");
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        try {
            _service.excluir(id);
            return ResponseEntity.status(HttpStatus.OK).body("professor excluídada com sucesso!!!");
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Não é possível excluir!");
        }
}
}

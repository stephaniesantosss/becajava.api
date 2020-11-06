package br.universidade.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.universidade.app.model.Curso;
import br.universidade.app.model.Disciplina;
import br.universidade.app.service.DisciplinaService;


@RestController

@RequestMapping("/disciplinas")
public class DisciplinaController {
	
private final DisciplinaService _service;
	
	@Autowired
	public DisciplinaController(DisciplinaService service) {
		_service = service;
	}
		
	@PostMapping
    public ResponseEntity inserir(@RequestBody Disciplina disciplina) {
        try {
            _service.inserir(disciplina);
            return ResponseEntity.status(HttpStatus.CREATED).body("Disciplina inserido com sucesso!");
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Não foi possível o cadastro do disciplina!");
        }
    }

    @GetMapping
    public ResponseEntity listar() {
        try {
            Iterable<Disciplina> disciplinas = _service.listar();
            return ResponseEntity.status(HttpStatus.OK).body(disciplinas);
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Não existe nenhum disciplina!");
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity listarUm(@PathVariable Long id) {
        try {
            Optional<Disciplina> disciplina = _service.listarUm(id);
            return ResponseEntity.status(HttpStatus.OK).body(disciplina);
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Disicplina não existe!");
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Disciplina disciplina) {
        try {
            _service.atualizar(id, disciplina);
            return ResponseEntity.status(HttpStatus.OK).body("disciplina atualizado com sucesso!!!");
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Não foi possível a atualização!");
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        try {
            _service.excluir(id);
            return ResponseEntity.status(HttpStatus.OK).body("disciplina excluídada com sucesso!!!");
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Não é possível excluir!");
        }
    }
}


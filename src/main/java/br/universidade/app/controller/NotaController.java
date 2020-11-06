package br.universidade.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.universidade.app.model.*;
import br.universidade.app.service.*;


@RestController
@RequestMapping("/notas")
public class NotaController {
private final NotaService _service;
	
	@Autowired
	public NotaController(NotaService service) {
		_service = service;
	}
		
	@PostMapping
    public ResponseEntity inserir(@RequestBody Nota nota) {
        try {
            _service.inserir(nota);
            return ResponseEntity.status(HttpStatus.CREATED).body("nota inserido com sucesso!");
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Não foi possível o cadastro do nota!");
        }
    }

    @GetMapping
    public ResponseEntity listar() {
        try {
            Iterable<Nota> notas = _service.listar();
            return ResponseEntity.status(HttpStatus.OK).body(notas);
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Não existe nenhuma nota!");
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity listarUm(@PathVariable Long id) {
        try {
            Optional<Nota> nota = _service.listarUm(id);
            return ResponseEntity.status(HttpStatus.OK).body(nota);
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Essa nota não existe!");
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Nota nota) {
        try {
            _service.atualizar(id, nota);
            return ResponseEntity.status(HttpStatus.OK).body("Nota atualizada com sucesso!!!");
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Não foi possível a atualização!");
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity excluir(@PathVariable Long Id) {
        try {
            _service.excluir(Id);
            return ResponseEntity.status(HttpStatus.OK).body("Nota excluídada com sucesso!!!");
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Não é possível excluir!");
        }
    }
}

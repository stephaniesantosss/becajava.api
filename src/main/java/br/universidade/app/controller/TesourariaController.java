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

import br.universidade.app.model.Aluno;
import br.universidade.app.model.Tesouraria;
import br.universidade.app.service.AlunoService;
import br.universidade.app.service.TesourariaService;

@RestController
@RequestMapping("/tesourarias")
public class TesourariaController {
private final TesourariaService _service;

@Autowired
public TesourariaController(TesourariaService service) {
	_service = service;
}

@PostMapping
public ResponseEntity inserir(@RequestBody Tesouraria tesouraria) {
    try {
        _service.inserir(tesouraria);
        return ResponseEntity.status(HttpStatus.CREATED).body("Boleto gerado!");

    } catch (Error e) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Não foi possível gerar o boleto!");
    }
}

@GetMapping
public ResponseEntity listar() {
    try {
        Iterable<Tesouraria> tesourarias = _service.listar();
        return ResponseEntity.status(HttpStatus.OK).body(tesourarias);
    } catch (Error e) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Transação não concluida!");
    }
}

@GetMapping(path = "/{id}")
public ResponseEntity listarUm(@PathVariable Long id) {
    try {
        Optional<Tesouraria> tesouraria = _service.listarUm(id);
        return ResponseEntity.status(HttpStatus.OK).body(tesouraria);
    } catch (Error e) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Transação não concluida!");
    }
}

@PutMapping(path = "/{id}")
public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Tesouraria tesouraria) {
    try {
        _service.atualizar(id, tesouraria);
        return ResponseEntity.status(HttpStatus.OK).body("Pagamento concluido!!!");
    } catch (Error e) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Pagamento ão efetuado!");
    }
}

@DeleteMapping(path = "/{id}")
public ResponseEntity excluir(@PathVariable Long id) {
    try {
        _service.excluir(id);
        return ResponseEntity.status(HttpStatus.OK).body("Transação cancelada!!!");
    } catch (Error e) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Não foi possivel cancelar!");
    }
}

}

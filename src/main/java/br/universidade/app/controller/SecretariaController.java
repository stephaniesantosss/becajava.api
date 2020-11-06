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


import br.universidade.app.model.Secretaria;
import br.universidade.app.service.SecretariaService;

@RestController
@RequestMapping("/secretarias")
public class SecretariaController {
private final SecretariaService _service;

@Autowired
public SecretariaController(SecretariaService service) {
	_service = service;
}

@PostMapping
public ResponseEntity inserir(@RequestBody Secretaria secretaria) {
    try {
        _service.inserir(secretaria);
        return ResponseEntity.status(HttpStatus.CREATED).body("Boleto gerado!");

    } catch (Error e) {
        return ResponseEntity.status(HttpStatus.CREATED).body("N�o foi poss�vel gerar o boleto!");
    }
}

@GetMapping
public ResponseEntity listar() {
    try {
        Iterable<Secretaria> secretaria = _service.listar();
        return ResponseEntity.status(HttpStatus.OK).body(secretaria);
    } catch (Error e) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Transa��o n�o concluida!");
    }
}

@GetMapping(path = "/{id}")
public ResponseEntity listarUm(@PathVariable Long id) {
    try {
        Optional<Secretaria> secretaria = _service.listarUm(id);
        return ResponseEntity.status(HttpStatus.OK).body(secretaria);
    } catch (Error e) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Transa��o n�o concluida!");
    }
}

@PutMapping(path = "/{id}")
public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Secretaria secretaria) {
    try {
        _service.atualizar(id, secretaria);
        return ResponseEntity.status(HttpStatus.OK).body("Pagamento concluido!!!");
    } catch (Error e) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Pagamento �o efetuado!");
    }
}

@DeleteMapping(path = "/{id}")
public ResponseEntity excluir(@PathVariable Long id) {
    try {
        _service.excluir(id);
        return ResponseEntity.status(HttpStatus.OK).body("Transa��o cancelada!!!");
    } catch (Error e) {
        return ResponseEntity.status(HttpStatus.CREATED).body("N�o foi possivel cancelar!");
    }
}

}

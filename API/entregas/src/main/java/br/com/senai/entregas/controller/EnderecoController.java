package br.com.senai.entregas.controller;

import br.com.senai.entregas.model.Endereco;
import br.com.senai.entregas.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService service) { enderecoService = service; }

    // Listar Todos
    @GetMapping
    ResponseEntity<List<Endereco>> listarEndereco() {
        // 1.
        List<Endereco> endereco = enderecoService.listarTodos();

        return ResponseEntity.ok(endereco);
    }

    // CADASTRAR
    @PostMapping
    public ResponseEntity<Endereco> cadastrarEndereco(
            @RequestBody Endereco endereco
    ) {
        // 1.
        enderecoService.cadastrarEndereco(endereco);

        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }
    // BUSCAR POR ID
    @GetMapping("'/{id}")

    public ResponseEntity<?> buscarEnderecoPorId(@PathVariable Integer id) {
        // 1.
        Endereco endereco = enderecoService.buscarPorId(id);

        // 2.
        if (endereco == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco " + id + " nao encontrado!");

        }
        // 3.
        return ResponseEntity.ok(endereco);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarEndereco(
    @PathVariable Integer id, @RequestBody Endereco enderecoNovo) {
    // 1.
        Endereco ed = enderecoService.atualizarEndereco(id, enderecoNovo);

        // 2. Se nao achar o endereco
        if (ed == null) {
            return ResponseEntity.status(404).body("Endereco " + id + " nao encontrado!");
        }

        // se achar retorno ok
        return ResponseEntity.ok(ed);

    }



}

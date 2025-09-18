package br.com.senai.entregas.controller;

import br.com.senai.entregas.model.Endereco;
import br.com.senai.entregas.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService service) { enderecoService = service; }

    // Listar Todos
    @GetMapping
    ResponseEntity<List<Endereco>> listarEndereco() {}
}

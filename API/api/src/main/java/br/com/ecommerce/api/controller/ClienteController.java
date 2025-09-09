package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    // Controller -> Service
    private final ClienteService clienteService;

    public ClienteController(ClienteService service) {
        clienteService = service;
    }

        // Listar Todos
    @GetMapping
    ResponseEntity<List<Cliente>> listarClientes() {
        // 1. Pegar a lista der clientes
        List<Cliente> clientes = clienteService.listarTodos();

        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(
    @RequestBody Cliente cliente
    ){
        //1. Tentar cadastrar o cliente
        // Codigo 200 - ok
        clienteService.cadastrarCliente(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

}

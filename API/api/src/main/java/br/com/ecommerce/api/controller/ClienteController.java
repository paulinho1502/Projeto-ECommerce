package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Controller de Cliente", description = "Metodo de Clientes")
public class ClienteController {
    // Controller -> Service
    private final ClienteService clienteService;

    public ClienteController(ClienteService service) {
        clienteService = service;
    }

        // Listar Todos
    @GetMapping
    @Operation(
            summary = "Listar todos Clientes",
            description = "Lista todos os clientes sem nenhuma restricao"
    )
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

    // Buscar Cliente por id
    // GET, POST, PUT, DELETE
    @GetMapping("/{id}")
    // Path Variable -. RECEBE UM VALOR NO LINK
    //Request Body -> Recebe dados pelo corpo
    public ResponseEntity<?> buscarClientePorId(@PathVariable Integer id) {
        // 1. Procurar o cliente
        Cliente cliente = clienteService.buscarPorId(id);


        // 2. Se não encontrar, retorno um erro
        if(cliente == null) {
            //Mais simples:
            // return ResponseEntity.notFound().build();
            // Mais detalhes:
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente "+ id + "não encontrado!");
        }

        // 3. se encontrar, retorno o Cliente
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Integer id) {

        // 1. verifico se o cliente existe
        Cliente cliente = clienteService.deletarCliente(id);

        // 2. Se não existir retorno erro
        if(cliente == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + id + "não encontrado!");

        }
        // 3. Se existir,retorno ok
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCLiente(
            @PathVariable Integer id, @RequestBody Cliente clienteNovo) {
        // 1. Tento atualizar cliente
        Cliente cl = clienteService.atualizarCliente(id, clienteNovo);

        // 2.Se não achar o cliente, mostro erro
        if(cl == null) {
            return ResponseEntity.status(404).body("Cliente não encontrado!");
        }
        // 3. Se achar retorno ok
        return ResponseEntity.ok(cl);
    }

}

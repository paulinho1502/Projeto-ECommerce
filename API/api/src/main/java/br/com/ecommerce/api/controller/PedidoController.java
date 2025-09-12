package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService service) { pedidoService = service; }

    @GetMapping
    ResponseEntity<List<Pedido>> listarPedido() {

        List<Pedido> pedidos = pedidoService.listarTodos();

        return ResponseEntity.ok(pedidos);
    }

    @PostMapping
    public ResponseEntity<Pedido> cadastrarPedido(
            @RequestBody Pedido pedido
            ){
        pedidoService.cadastrarPedido(pedido);

        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);

    }

    @GetMapping("/{id}")

    public ResponseEntity<?> buscarPedidoPorId(@PathVariable Integer id) {
        // 1.
        Pedido pedido = pedidoService.buscarPorId(id);

        // 2.
        if(pedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pedido" + id + "não encontrado!");

        }
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPedido(@PathVariable Integer id) {

        // 1.
        Pedido pedido = pedidoService.deletarPedido(id);

        // 2.
        if(pedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pedido " + id + "não encontrado1");

        }
        return ResponseEntity.ok(pedido);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPedido(
            @PathVariable Integer id, @RequestBody Pedido pedidoNovo) {
        // 1. Tento atualizar Pedido
        Pedido pd = pedidoService.atualizarPedido(id, pedidoNovo);

        // 2. Se nao achar retorno erro
        if(pd == null) {
            return ResponseEntity.status(404).body("Pedido nao encontrado!");
        }
        // 3. Se achar Atualizp
        return ResponseEntity.ok(pd);
    }

}

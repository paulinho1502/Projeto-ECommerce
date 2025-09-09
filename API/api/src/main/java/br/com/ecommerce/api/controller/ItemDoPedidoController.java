package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.ItemDoPedido;
import br.com.ecommerce.api.service.ItemDoPedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itemdospedidos")
public class ItemDoPedidoController {

    private final ItemDoPedidoService itemdopedidoService;

    public ItemDoPedidoController(ItemDoPedidoService service) {
        itemdopedidoService = service;
    }

    @GetMapping
    ResponseEntity<List<ItemDoPedido>> listarItemDoPedido() {

        List<ItemDoPedido> itemdopedidos = itemdopedidoService.listarTodos();

        return ResponseEntity.ok(itemdopedidos);
    }

    @PostMapping
    public ResponseEntity<ItemDoPedido> cadastrarItemDoPedido(
            @RequestBody ItemDoPedido itemdopedido
    ) {
itemdopedidoService.cadastrarItemDoPedido(itemdopedido);

return ResponseEntity.status(HttpStatus.CREATED).body(itemdopedido);

    }
}

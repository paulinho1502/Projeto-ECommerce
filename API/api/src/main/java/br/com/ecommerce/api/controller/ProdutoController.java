package br.com.ecommerce.api.controller;


import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService service) {
        produtoService = service;
    }

    @GetMapping
    ResponseEntity<List<Produto>> listarProdutos() {

        List<Produto> produtos = produtoService.listarTodos();

        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(
            @RequestBody Produto produto
    ){
        produtoService.cadastrarProduto(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping("/{id}")

    public ResponseEntity<?> buscarProdutoPorId(@PathVariable Integer id) {
        // 1.
        Produto produto = produtoService.buscarPorId(id);

        // 2.
        if(produto == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + id + "não encontrado!");

        }

        // 3.
        return ResponseEntity.ok(produto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Integer id) {

        // 1.
        Produto produto = produtoService.deletarProduto(id);

        // 2.
        if(produto == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto " + id + "não encontrado!");

        }

        // 3.
        return ResponseEntity.ok(produto);
    }

}

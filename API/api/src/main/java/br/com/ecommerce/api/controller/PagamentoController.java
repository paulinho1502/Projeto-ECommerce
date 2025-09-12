package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.service.PagamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService service) {pagamentoService = service; }

    @GetMapping
    ResponseEntity<List<Pagamento>> listarPagamentos(){
        List<Pagamento> pagamentos = pagamentoService.listarTodos();

        return ResponseEntity.ok(pagamentos);


    }

    @PostMapping
    public ResponseEntity<Pagamento> cadastrarPagamento(
            @RequestBody Pagamento pagamento
    ){
        pagamentoService.cadastrarPagamento(pagamento);

        return ResponseEntity.status(HttpStatus.CREATED).body(pagamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> bucarPagamentoPorId(@PathVariable Integer id) {
        // 1.
        Pagamento pagamento = pagamentoService.buscarPorId(id);
        // 2.
        if(pagamento == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pagament0 " + id +" nao encontrado");
        }
            // 3.
            return ResponseEntity.ok(pagamento);
        }


    @DeleteMapping("/{id}")

    public ResponseEntity<?> deletarPagamento(@PathVariable Integer id) {
        // 1.
        Pagamento pagamento = pagamentoService.deletarPagamento(id);

        // 2.
        if(pagamento == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pagamento " + id + "não encontrado");
        }

        // 3.
        return ResponseEntity.ok(pagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPagamento(
            // 1.
            @PathVariable Integer id, @RequestBody Pagamento pagamentoNovo){
        Pagamento pg = pagamentoService.atualizarPagamento(id, pagamentoNovo);
        // 2.
        if(pg == null){
            return ResponseEntity.status(404).body("Pagamento não encontrado!");
        }
        // 3.
        return ResponseEntity.ok(pg);
    }


}

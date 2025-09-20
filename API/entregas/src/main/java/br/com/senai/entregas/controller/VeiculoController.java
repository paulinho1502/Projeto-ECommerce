package br.com.senai.entregas.controller;



import br.com.senai.entregas.model.Veiculo;
import br.com.senai.entregas.service.VeiculoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService service) {
        veiculoService = service;
    }

    // listar
    @GetMapping
    ResponseEntity<List<Veiculo>> listarVeiculo() {
        // 1.
        List<Veiculo> veiculos = veiculoService.listarTodos();

        return ResponseEntity.ok(veiculos);

    }

    // CADASTRAR
    @PostMapping
    public ResponseEntity<Veiculo> cadastrarVeiculo(
            @RequestBody Veiculo veiculo){
        // 1. tentar cadastrar veiculo

        veiculoService.cadastrarVeiculo(veiculo);

        return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);

    }

    // buscar
    @GetMapping("/{id}")

    public ResponseEntity<?> buscarVeiculoPorId(@PathVariable Integer id) {
        // 1. procurar um veiculo
        Veiculo veiculo = veiculoService.buscarPorId(id);

        // 2.
        if (veiculo != null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo " + id + " nao encontrado!");
        }
        return ResponseEntity.ok(veiculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarVeiculo(@PathVariable Integer id) {

        //1
        Veiculo veiculo = veiculoService.deletarVeiculo(id);

        // 2.
        if (veiculo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo " + id + "nao encontrado!");
        }

        // 3.
        return ResponseEntity.ok(veiculo);
    }

        // ATUALIZAR
        @PutMapping("/{id}")
        public ResponseEntity<?> atualizarVeiculo (
                @PathVariable Integer id , @RequestBody Veiculo veiculoNovo) {
            // 1.
            Veiculo ve = veiculoService.atualizarVeiculo(id, veiculoNovo);

            // 2
            if (ve == null) {
                return ResponseEntity.status(404).body("Veiculo " + id + " nao encontrado!");
            }

            //3,
            return ResponseEntity.ok(ve);

        }



}
package br.com.senai.entregas.controller;

import br.com.senai.entregas.model.TipoUsuario;
import br.com.senai.entregas.model.Usuario;
import br.com.senai.entregas.service.TipoUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipousuarios")
public class TipoUsuarioController {

    private final TipoUsuarioService tipoUsuarioService;

    public TipoUsuarioController(TipoUsuarioService service) { tipoUsuarioService = service;}

    // Listar
    @GetMapping
    ResponseEntity<List<TipoUsuario>> listarTipoUsuario() {
        // 1. Pegar a lista de usuarios
        List<TipoUsuario> tipoUsuarios = tipoUsuarioService.listarTodos();

        return ResponseEntity.ok(tipoUsuarios);
    }

    // CADASTRAR
    @PostMapping
    public ResponseEntity<TipoUsuario> cadastrarTipoUsuario(
            @RequestBody TipoUsuario tipoUsuario
    ){
        // 1. tentar cadastrar um tipo de usuario
        tipoUsuarioService.cadastrarTipoUsuario(tipoUsuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(tipoUsuario);
    }

    // Buscar por id
    @GetMapping("/{id}")

    public ResponseEntity<?> buscarTipoUsuarioPorId(@PathVariable Integer id) {
        // 1. Procurar o tipo
        TipoUsuario tipoUsuario = tipoUsuarioService.buscarPorId(id);

        // 2. Se nao encontrar, retorno nullo
        if (tipoUsuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario " + id + " nao encontrado!");
        }

        return ResponseEntity.ok(tipoUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarTipoUsuario(@PathVariable Integer id) {

        // 1. verifico se o cliente existe
        TipoUsuario tipoUsuario = tipoUsuarioService.deletarTipoUsuario(id);

        // 2.
        if (tipoUsuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo usuario " + id + " nao encontrado!");
        }

        // 3.
        return ResponseEntity.ok(tipoUsuario);

    }

        // ATUALIZAR
        @PutMapping("/{id}")
        public ResponseEntity<?> atualizarTipoUsuario(
                @PathVariable Integer id , @RequestBody TipoUsuario tipoUsuarioNovo) {
            // 1. Tento atualizar cliente
            TipoUsuario tipo = tipoUsuarioService.atualizarTipoUsuario(id, tipoUsuarioNovo);

            // 2. Se não achar o cliente
            if(tipo == null) {
                return ResponseEntity.status(404).body("Usuario " + id + " nao encontrado!");
            }

            // Se achar retorno ok
            return ResponseEntity.ok(tipo);

    }
}

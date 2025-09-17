package br.com.senai.entregas.controller;


import br.com.senai.entregas.model.Usuario;
import br.com.senai.entregas.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios:")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService service) { usuarioService = service;}

    // Listar Todos
    @GetMapping
    @Operation(
            summary = "Listar todos os Usuarios",
            description = "Lista todos os clientes sem nenhuma restricao"
    )
    ResponseEntity<List<Usuario>> listarUsuarios() {
        // 1. Pegar a lista de usuarios
        List<Usuario> usuarios = usuarioService.listraTodos();

        return ResponseEntity.ok(usuarios);
    }

    // CADASTRAR
    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(
            @RequestBody Usuario usuario
    ) {

        //1. Tentar cadastrar usuario
        usuarioService.cadastrarUsuario(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    // Buscar usuario por ID
    @GetMapping("/{id}")

    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Integer id) {
        // 1. Procurar o usuario
        Usuario usuario = usuarioService.buscarPorId(id);

        // 2. Se nao encontrar, retornom nullo
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario" + id + " nao encontrado");
        }

        return ResponseEntity.ok(usuario);
    }


}

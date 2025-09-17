package br.com.senai.entregas.service;


import br.com.senai.entregas.model.Usuario;
import br.com.senai.entregas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository repo) {
        usuarioRepository = repo;
    }

    // Listar todos os usuarios
    public List<Usuario> listraTodos(){
        return usuarioRepository.findAll();
    }

    // CADASTRAR
    public Usuario cadastrarUsuario(Usuario us) {
        return usuarioRepository.save(us);
    }

    // BUSCAR
    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // DETELAR
    public Usuario deletarUsuario(Integer id) {
        // 1. verifico se o usuatio existe ou nao
        Usuario usuario = buscarPorId(id);


        // 2. Se nao existir retorno nullo
        if (usuario == null) {
            return null;
        }

        // 3. Se existir, excluo
        usuarioRepository.delete(usuario);
        return usuario;

    }

    // ATUALIZAR
    public Usuario atualizarUsuario(Integer id, Usuario usuarioNovo) {
        // 1. procurar quem eu quero atualizar
        Usuario usuarioAntigo = buscarPorId(id);

        // 2. Se eu nao ahar retoro nullo
        if (usuarioAntigo == null) {
            return null;
        }
        // 3. Se eu achar eu atualizo
        usuarioAntigo.setSenha(usuarioNovo.getSenha());
        usuarioAntigo.setTipoUsuario(usuarioNovo.getTipoUsuario());
        usuarioAntigo.setEmail(usuarioNovo.getEmail());
        usuarioAntigo.setNomeCompleto(usuarioNovo.getNomeCompleto());
        return usuarioRepository.save(usuarioAntigo);
    }
}

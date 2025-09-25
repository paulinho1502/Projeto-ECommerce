package br.com.senai.entregas.service;


import br.com.senai.entregas.model.Usuario;
import br.com.senai.entregas.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repo, PasswordEncoder passwordEnconder) {
        usuarioRepository = repo;
        this.passwordEncoder = passwordEnconder;
    }

    // Listar todos os usuarios
    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

    // CADASTRAR
    public Usuario cadastrarUsuario(Usuario us) {

        String senhaCriptografada = passwordEncoder.encode(us.getSenha());

        us.setSenha(senhaCriptografada);


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

        // 2. Se eu nao achar retoro nullo
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

package br.com.senai.entregas.service;



import br.com.senai.entregas.model.TipoUsuario;
import br.com.senai.entregas.repository.TipoUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioService {

    private final TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioService(TipoUsuarioRepository repo) {tipoUsuarioRepository = repo; }

    // Listar Todos os tipos de usuarios
    public List<TipoUsuario> listarTodos(){ return tipoUsuarioRepository.findAll(); }

    // CADASTRAR
    public TipoUsuario cadastrarTipoUsuario(TipoUsuario tipo) {return tipoUsuarioRepository.save(tipo); }

    // BUSCAR POR ID
    public TipoUsuario buscarPorId(Integer id) { return tipoUsuarioRepository.findById(id).orElse(null); }

    // DELETAR
    public TipoUsuario deletarTipoUsuario(Integer id ) {
        // 1. verifico se existe ou nao.
        TipoUsuario tipoUsuario = buscarPorId(id);

        // 2. Se nao existir retorno nullo
        if (tipoUsuario == null){
            return null;
        }

        // 3. Se existir, excluo
        tipoUsuarioRepository.delete(tipoUsuario);
        return tipoUsuario;
    }

    // ATUALIZAR
    public TipoUsuario atualizarTipoUsuario(Integer id, TipoUsuario tipoUsuarioNovo) {
        // 1. procurar quem eu quero atualizar
        TipoUsuario tipoUsuarioAntigo = buscarPorId(id);

        // 2. Se eu nao achar retorno nullo
        if (tipoUsuarioAntigo == null) {
            return null;
        }
        // 3. Se eu achar eu atualizar
        tipoUsuarioAntigo.setDescricao(tipoUsuarioNovo.getDescricao());
        return tipoUsuarioRepository.save(tipoUsuarioAntigo);
    }
}

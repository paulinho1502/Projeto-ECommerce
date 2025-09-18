package br.com.senai.entregas.service;


import br.com.senai.entregas.model.Endereco;
import br.com.senai.entregas.model.TipoUsuario;
import br.com.senai.entregas.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository repo) { enderecoRepository = repo; }

    // Listar
    public List<Endereco> listarTodos() { return enderecoRepository.findAll(); }

    // CADASTRAR
    public Endereco cadastrarEndereco(Endereco ed) { return enderecoRepository.save(ed); }

    // BUSCAR
    public Endereco buscarPorId(Integer id) { return enderecoRepository.findById(id).orElse(null); }

    // DELETAR
    public Endereco deletarEndereco(Integer id) {
        // 1. verifico se o e dereco existe ou nao
        Endereco endereco = buscarPorId(id);

        // 2.
        if (endereco == null) {
            return null;
        }

        // 3.
        enderecoRepository.delete(endereco);
        return endereco;
    }

    // ATUALIZAR
    public Endereco atualizarEndereco(Integer id, Endereco enderecoNovo) {
        // 1.
        Endereco enderecoAntigo = buscarPorId(id);

        // 2. Se eu nao achar retorno nullo
        if (enderecoAntigo == null) {
            return null;
        }
        // 3.
        enderecoAntigo.setCep(enderecoNovo.getCep());
        enderecoAntigo.setCidade(enderecoNovo.getCidade());
        enderecoAntigo.setNumero(enderecoNovo.getNumero());
        enderecoAntigo.setLogradouro(enderecoNovo.getLogradouro());
        enderecoAntigo.setUsuario(enderecoNovo.getUsuario());
        return enderecoRepository.save(enderecoAntigo);

    }
}

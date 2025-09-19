package br.com.senai.entregas.service;



import br.com.senai.entregas.model.Veiculo;
import br.com.senai.entregas.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository repo) {
        veiculoRepository = repo;
    }

    // Listar todos os usuarios
    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    // cadastrar
    public Veiculo cadastrarVeiculo(Veiculo vei) {
        return veiculoRepository.save(vei);
    }

    // buscar

    public Veiculo buscarPorId(Integer id) {
        return veiculoRepository.findById(id).orElse(null);
    }

    // DELETAR

    public Veiculo deletarVeiculo(Integer id) {
        // 1. verifico se o usuatio existe ou nao
        Veiculo veiculo = buscarPorId(id);


        // 2. Se nao existir retorno nullo
        if (veiculo == null) {
            return null;
        }

        // 3. Se existir, excluo
        veiculoRepository.delete(veiculo);
        return veiculo;
    }

    // ATUALIZAR
    public Veiculo atualizarVeiculo(Integer id, Veiculo veiculoNovo) {
        // 1. procurar quem eu quero atualizar
        Veiculo veiculoAntigo = buscarPorId(id);

        // 2. Se eu nao achar retoro nullo
        if (veiculoAntigo == null) {
            return null;
        }
        // 3.
        veiculoAntigo.setTipo(veiculoNovo.getTipo());
        veiculoAntigo.setModelo(veiculoNovo.getModelo());
        veiculoAntigo.setPlaca(veiculoNovo.getPlaca());
        return veiculoRepository.save(veiculoAntigo);
    }
}

package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository repo) { pagamentoRepository = repo;}

    public List<Pagamento> listarTodos() { return pagamentoRepository.findAll();}

public Pagamento cadastrarPagamento(Pagamento pg){
        return pagamentoRepository.save(pg);
}

public Pagamento buscarPorId(Integer id){

    return pagamentoRepository.findById(id).orElse(null);
}

// DELETE
    public Pagamento deletarPagamento(Integer id) {
        // 1.
        Pagamento pagamento = buscarPorId(id);

        // 2.
        if (pagamento == null) {
            return null;
        }

        // 3.
        pagamentoRepository.delete(pagamento);
        return pagamento;
    }

    // ATUALZAR
public Pagamento atualizarPagamento(Integer id, Pagamento pagamentoNovo) {
        // 1.
    Pagamento pagamentoAntigo = buscarPorId(id);
    // 2.
    if (pagamentoAntigo == null) {
        return null;
    }

    // 3.
    pagamentoAntigo.setDataPagamento(pagamentoNovo.getDataPagamento());
    pagamentoAntigo.setFormaPagamento(pagamentoNovo.getFormaPagamento());
    pagamentoAntigo.setStatus(pagamentoNovo.getStatus());
    return pagamentoRepository.save(pagamentoAntigo);

}

}

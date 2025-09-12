package br.com.ecommerce.api.service;


import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository repo) {
        pedidoRepository = repo;
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }


    public Pedido cadastrarPedido(Pedido pd) {
        return pedidoRepository.save(pd);
    }


    public Pedido buscarPorId(Integer id) {
        return pedidoRepository.findById(id).orElse(null);

    }

    // DELETE
    public Pedido deletarPedido(Integer id) {
        // 1.
        Pedido pedido = buscarPorId(id);

        // 2.
        if (pedido == null) {
            return null;
        }
        pedidoRepository.delete(pedido);
        return pedido;
    }

    // ATUALIZAR
    public Pedido atualizarPedido(Integer id, Pedido pedidoNovo) {
        Pedido pedidoAntigo = buscarPorId(id);

        // 2. Se nao achra retorno nulo
        if (pedidoAntigo == null) {
            return null;
        }

        // 3. Se achar eu atualizo
        pedidoAntigo.setDataPedido(pedidoNovo.getDataPedido());
        pedidoAntigo.setStatus(pedidoNovo.getStatus());
        pedidoAntigo.setValorTotal(pedidoNovo.getValorTotal());
        return pedidoRepository.save(pedidoAntigo);
    }
}

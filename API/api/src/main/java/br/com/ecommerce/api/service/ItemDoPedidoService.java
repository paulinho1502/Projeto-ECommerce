package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.ItemDoPedido;
import br.com.ecommerce.api.repository.ItemDoPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemDoPedidoService {


    private final ItemDoPedidoRepository itemdopedidoRepository;

    public ItemDoPedidoService(ItemDoPedidoRepository  repo) {
        itemdopedidoRepository = repo;
    }

    public List<ItemDoPedido> listarTodos(){
        return itemdopedidoRepository.findAll();
    }

    public ItemDoPedido cadastrarItemDoPedido(ItemDoPedido item){
        return itemdopedidoRepository.save(item);
    }


    public ItemDoPedido buscarPorId(Integer id) {
        return itemdopedidoRepository.findById(id).orElse(null);
    }

    // DELETE
    public ItemDoPedido deletarItem(Integer id){
        // 1.
        ItemDoPedido item = buscarPorId(id);

        // 2.
        if (item == null) {
            return null;

        }

        // 3.
        itemdopedidoRepository.delete(item);
        return item;
    }

    // Atualizar
    public ItemDoPedido atualizarItem(Integer id, ItemDoPedido itemNovo){
        // 1. Procurar quem quero atualizar
        ItemDoPedido itemAntigo = buscarPorId(id);

        // 2. Se eu nao achar retorno nullo
        if (itemAntigo == null) {
            return null;
        }

        // 3.
        itemAntigo.setQuantidade(itemNovo.getQuantidade());
        return itemdopedidoRepository.save(itemAntigo);
    }
}

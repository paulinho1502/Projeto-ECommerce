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

}

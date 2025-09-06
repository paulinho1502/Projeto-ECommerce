package br.com.ecommerce.api.repository;

import br.com.ecommerce.api.model.ItemDoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Item_do_pedidoRepository extends JpaRepository<ItemDoPedido, Integer> {

}

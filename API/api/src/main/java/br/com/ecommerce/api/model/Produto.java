package br.com.ecommerce.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "produto", schema = "ecommerce")
public class Produto {
    @Id
    @Column(name = "id_produto", nullable = false)
    private Integer id;

    @Column(name = "nome_produto", nullable = false, length = Integer.MAX_VALUE)
    private String nomeProduto;

    @Column(name = "descricao", nullable = false, length = Integer.MAX_VALUE)
    private String descricao;

    @Column(name = "preco", nullable = false, precision = 10, scale = 4)
    private BigDecimal preco;

    @Column(name = "estoque", nullable = false)
    private Integer estoque;

    @Column(name = "imagem_url", nullable = false, length = Integer.MAX_VALUE)
    private String imagemUrl;

}
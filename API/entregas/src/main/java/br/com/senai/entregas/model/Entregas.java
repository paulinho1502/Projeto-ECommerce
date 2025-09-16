package br.com.senai.entregas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "entregas")
public class Entregas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entregas_id")
    private Integer entregasId;

    @Column(name = "descricao_produto",nullable = false, columnDefinition = "TEXT")
    private String descricaoProduto;
}

package br.com.senai.entregas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok
@Getter
@Setter
// OBRIGATORIO
@NoArgsConstructor
@AllArgsConstructor
// JPA
// Entity - Informa que essa classe e uma tabela
@Entity
// Table - permite que voce configure a tabela
@Table(name = "Tipo_usuario")
public class TipoUsuario {

    // @Id - Avisa que aquela coluna e uma chave primaria
    @Id
    // Generates Value - define que a chave primaria e feita pelo Banco de Dados
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Column - configura a coluna
    // nullable - se poder ser nullo ou nao
    @Column(name = "tipo_usuario_id", nullable = false)
    private Integer tipoUsuarioId;

    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;

}

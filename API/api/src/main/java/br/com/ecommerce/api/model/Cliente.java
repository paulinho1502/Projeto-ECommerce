package br.com.ecommerce.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "cliente", schema = "ecommerce")
public class Cliente {
    @Id
    @Column(name = "id_cliente", nullable = false)
    private Integer id;

    @Column(name = "nome_completo", nullable = false, length = Integer.MAX_VALUE)
    private String nomeCompleto;

    @Column(name = "email", nullable = false, length = Integer.MAX_VALUE)
    private String email;

    @Column(name = "senha", nullable = false, length = Integer.MAX_VALUE)
    private String senha;

    @Column(name = "telefone", nullable = false, length = Integer.MAX_VALUE)
    private String telefone;

    @Column(name = "data_cadastro", nullable = false)
    private OffsetDateTime dataCadastro;

}
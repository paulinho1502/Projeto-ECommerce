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
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    @Column(name = "nome_completo",nullable = false, columnDefinition = "TEXT")
    private String nomeCompleto;

    @Column(name = "email", nullable = false, columnDefinition = "TEXT",unique = true)
    private String email;

    @Column(name = "senha", nullable = false, columnDefinition = "TEXT")
    private String senha;

// usuario tem um tipo de usuario, Colocando uma classe dentro de outra
    // colocar a chave estrangeira
    // Muitos usario para um TIPO USARIO
    // FetchType.EAGER - Carrega os dados juntos
    // optional - Se e obrigatorio ou nao

    @ManyToOne(fetch = FetchType.EAGER, optional = false)

   // Avisar paara o java, qual coluna do tipo usuario que vou relacionar
    @JoinColumn(name = "tipo_usuario_id")
    private TipoUsuario tipoUsuario;



}

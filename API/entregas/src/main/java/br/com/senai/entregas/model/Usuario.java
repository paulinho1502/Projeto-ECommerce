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
    private Integer UsuarioId;

    @Column(name = "nome_completo",nullable = false, columnDefinition = "TEXT")
    private String NomeCompleto;

    @Column(name = "email", nullable = false, columnDefinition = "TEXT",unique = true)
    private String Email;

    @Column(name = "senha", nullable = false, columnDefinition = "TEXT")
    private String Senha;



}

package com.example.projetoUsuario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table (name = "pessoas")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn (name = "tipo_pessoa", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Pessoa {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, length = 100)
    private String nome;

    @Column (nullable = false, unique = true, length = 100)
    private String email;

    @Column (nullable = false)
    private String telefone;

    @Column (name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @Column (name = "data_atualização")
    private LocalDateTime dataAtualizacao;

    @Column (nullable = false)
    private Boolean ativo = true;

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }
}

package com.example.projetoUsuario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("USUARIO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends Pessoa{
    @Column (nullable = false, unique = false, length = 50)
    private String username;

    @Column (nullable = false)
    private String senha;

    @Enumerated (EnumType.STRING)
    @Column (nullable = false)
    private TipoUsuario tipoUsuario = TipoUsuario.USER;

    @Column (nullable = false)
    private Boolean verificado = false;

    @Column (length = 255)
    private String fotoPerfil;

    public Usuario(String nome, String email, String telefone, String username,
                   String senha, TipoUsuario tipoUsuario, String fotoPerfil) {
        super ();
        this.setNome(nome);
        this.setEmail(email);
        this.setTelefone(telefone);
        this.username = username;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario.USER;
    }

}

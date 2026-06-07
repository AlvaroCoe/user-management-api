package com.example.projetoUsuario.dto.response;

import com.example.projetoUsuario.entity.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String username;
    private TipoUsuario tipoUsuario;
    private Boolean verificado;
    private String fotoPerfil;
    private Boolean ativo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}

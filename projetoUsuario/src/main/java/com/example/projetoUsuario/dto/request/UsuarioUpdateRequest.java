package com.example.projetoUsuario.dto.request;

import com.example.projetoUsuario.entity.TipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioUpdateRequest {

    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @Email(message = "Email deve ser válido")
    private String email;

    @Pattern(regexp = "^\\(\\d{2}\\)\\s?9?\\d{4}-\\d{4}$",
            message = "Telefone deve estar no formato (XX) 9XXXX-XXXX")
    private String telefone;

    private TipoUsuario tipoUsuario;

    private Boolean verificado;

    private String fotoPerfil;
}


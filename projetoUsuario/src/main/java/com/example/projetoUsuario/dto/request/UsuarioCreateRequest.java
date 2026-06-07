package com.example.projetoUsuario.dto.request;

import com.example.projetoUsuario.entity.TipoUsuario;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCreateRequest {

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    private String email;

    @NotBlank(message = "Telefone é obrigatório")
    @Pattern(regexp = "^\\(\\d{2}\\)\\s?9?\\d{4}-\\d{4}$",
            message = "Telefone deve estar no formato (XX) 9XXXX-XXXX")
    private String telefone;

    @NotBlank(message = "Username é obrigatório")
    @Size(min = 3, max = 50, message = "Username deve ter entre 3 e 50 caractere")
    private String username;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, max = 100, message = "Senha deve ter entre 6 e 100 caracteres")
    private String senha;

    @NotNull(message = "Tipo de usuário é obrigatório")
    private TipoUsuario tipoUsuario;
}



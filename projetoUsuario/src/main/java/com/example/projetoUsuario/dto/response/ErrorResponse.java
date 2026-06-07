package com.example.projetoUsuario.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private Integer status;
    private String mensagem;
    private String detalhes;
    private LocalDateTime timestamp;
    private String caminho;
}

package com.example.projetoUsuario.entity;

public enum TipoUsuario {

    ADMIN ("Administrador"),
    USER ("Usuário Comum"),
    MODERADOR ("Moderador");

    private final String descricao;

    TipoUsuario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

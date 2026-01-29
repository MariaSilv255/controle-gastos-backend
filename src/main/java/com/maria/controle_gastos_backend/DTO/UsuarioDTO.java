package com.maria.controle_gastos_backend.DTO;

import com.maria.controle_gastos_backend.entities.Usuario;

public class UsuarioDTO {

    private Long id;
    private String nome;
    private String telefone;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.telefone = usuario.getTelefone();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

package br.com.guilherme.adopet.api.dto;

import br.com.guilherme.adopet.api.model.Abrigo;

public record AbrigoDTO(Long id, String nome, String telefone, String email) {

    public AbrigoDTO(Abrigo abrigo) {
        this(abrigo.getId(), abrigo.getNome(), abrigo.getTelefone(), abrigo.getEmail());
    }
}

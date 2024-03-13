package br.com.guilherme.adopet.api.dto;

import jakarta.validation.constraints.NotNull;

public record AprovacaoAdocaoDTO(
        @NotNull
        Long idAdocao) {
}

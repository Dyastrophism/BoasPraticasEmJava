package br.com.guilherme.adopet.api.validations;

import br.com.guilherme.adopet.api.dto.SolicitacaoAdocaoDTO;

public interface ValidacaoSolicitacaoAdocao {
    void validar(SolicitacaoAdocaoDTO dto);
}

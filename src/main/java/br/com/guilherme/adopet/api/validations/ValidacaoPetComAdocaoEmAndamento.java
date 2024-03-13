package br.com.guilherme.adopet.api.validations;

import br.com.guilherme.adopet.api.dto.SolicitacaoAdocaoDTO;
import br.com.guilherme.adopet.api.exception.ValidacaoException;
import br.com.guilherme.adopet.api.model.Adocao;
import br.com.guilherme.adopet.api.model.Pet;
import br.com.guilherme.adopet.api.model.StatusAdocao;
import br.com.guilherme.adopet.api.repository.AdocaoRepository;
import br.com.guilherme.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidacaoPetComAdocaoEmAndamento implements ValidacaoSolicitacaoAdocao {

    @Autowired
    private AdocaoRepository adocaoRepository;
    @Autowired
    private PetRepository petRepository;
    public void validar(SolicitacaoAdocaoDTO dto) {
        boolean petTemAdocaoEmAndamento = adocaoRepository.existsByPetIdAndStatus(dto.idPet(),
                StatusAdocao.AGUARDANDO_AVALIACAO);
        if (petTemAdocaoEmAndamento) {
            throw  new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");
        }
    }

}

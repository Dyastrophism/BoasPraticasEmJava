package br.com.guilherme.adopet.api.validations;

import br.com.guilherme.adopet.api.dto.SolicitacaoAdocaoDTO;
import br.com.guilherme.adopet.api.exception.ValidacaoException;
import br.com.guilherme.adopet.api.model.Pet;
import br.com.guilherme.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoPetDisponivel implements ValidacaoSolicitacaoAdocao{

    @Autowired
    private PetRepository petRepository;
    public void validar(SolicitacaoAdocaoDTO dto) {
        Pet pet = petRepository.getReferenceById(dto.idPet());
        if (pet.getAdotado()) {
            throw new ValidacaoException("Pet já foi adotado!");
        }
    }
}

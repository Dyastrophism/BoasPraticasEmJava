package br.com.guilherme.adopet.api.service;

import br.com.guilherme.adopet.api.dto.CadastroPetDTO;
import br.com.guilherme.adopet.api.dto.PetDTO;
import br.com.guilherme.adopet.api.model.Abrigo;
import br.com.guilherme.adopet.api.model.Pet;
import br.com.guilherme.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public List<PetDTO> buscarPetsDisponiveis() {
        return repository.findAllByAdotadoFalse().stream().map(PetDTO::new).toList();
    }

    public void cadastrarPet(Abrigo abrigo, CadastroPetDTO dto) {
        repository.save(new Pet(dto, abrigo));
    }

}

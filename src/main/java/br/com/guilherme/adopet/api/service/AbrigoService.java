package br.com.guilherme.adopet.api.service;

import br.com.guilherme.adopet.api.dto.AbrigoDTO;
import br.com.guilherme.adopet.api.dto.CadastroAbrigoDTO;
import br.com.guilherme.adopet.api.dto.PetDTO;
import br.com.guilherme.adopet.api.exception.ValidacaoException;
import br.com.guilherme.adopet.api.model.Abrigo;
import br.com.guilherme.adopet.api.repository.AbrigoRepository;
import br.com.guilherme.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbrigoService {
    @Autowired
    private AbrigoRepository abrigoRepository;
    @Autowired
    private PetRepository petRepository;

    public List<AbrigoDTO> listar() {
        return abrigoRepository.findAll().stream().map(AbrigoDTO::new).toList();
    }

    public void cadastrar(CadastroAbrigoDTO dto) {
        boolean jaCadastrado = abrigoRepository.existsByNomeOrTelefoneOrEmail(dto.nome(), dto.telefone(), dto.email());
        if (jaCadastrado) {
            throw new ValidacaoException("Dados já cadastrados para outro abrigo!");
        }

        abrigoRepository.save(new Abrigo(dto));
    }

    public List<PetDTO> listarPetsDoAbrigo(String idOuNome) {
        Abrigo abrigo = carregarAbrigo(idOuNome);
        return petRepository.findByAbrigo(abrigo).stream().map(PetDTO::new).toList();
    }

    public Abrigo carregarAbrigo(String idOuNome) {
        Optional<Abrigo> optional;
        try {
            Long id = Long.parseLong(idOuNome);
            optional = abrigoRepository.findById(id);
        } catch (NumberFormatException exception) {
            optional = abrigoRepository.findByNome(idOuNome);
        }
        return optional.orElseThrow(() -> new ValidacaoException("Abrigo não encontrado."));
    }
}

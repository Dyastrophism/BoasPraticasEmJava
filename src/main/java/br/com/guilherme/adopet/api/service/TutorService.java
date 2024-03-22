package br.com.guilherme.adopet.api.service;

import br.com.guilherme.adopet.api.dto.AtualizacaoTutorDTO;
import br.com.guilherme.adopet.api.dto.CadastroTutorDTO;
import br.com.guilherme.adopet.api.exception.ValidacaoException;
import br.com.guilherme.adopet.api.model.Tutor;
import br.com.guilherme.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {
    @Autowired
    private TutorRepository repository;

    public void cadastrar(CadastroTutorDTO dto) {
        boolean jaCadastrado = repository.existsByTelefoneOrEmail(dto.telefone(), dto.email());
        if (jaCadastrado) {
            throw new ValidacaoException("Dados já cadastrados para outro trutor!");
        }
        repository.save(new Tutor(dto));
    }

    public void atualizar(AtualizacaoTutorDTO dto) {
        Tutor tutor = repository.getReferenceById(dto.id());
        tutor.atualizarDados(dto);
    }
}

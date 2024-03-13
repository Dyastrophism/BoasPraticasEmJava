package br.com.guilherme.adopet.api.dto;

import br.com.guilherme.adopet.api.model.Pet;
import br.com.guilherme.adopet.api.model.TipoPet;

public record DadosDetalhesPetDTO(Long id, TipoPet tipo, String nome, String raca, Integer idade) {

    public DadosDetalhesPetDTO(Pet pet) {
        this(pet.getId(), pet.getTipo(), pet.getNome(), pet.getRaca(), pet.getIdade());
    }
}

package br.com.guilherme.adopet.api.controller;

import br.com.guilherme.adopet.api.dto.DadosDetalhesPetDTO;
import br.com.guilherme.adopet.api.model.Pet;
import br.com.guilherme.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRepository repository;

    @GetMapping
    public ResponseEntity<List<DadosDetalhesPetDTO>> listarTodosDisponiveis() {
        List<Pet> pets = repository.findAll();
        List<DadosDetalhesPetDTO> disponiveis = new ArrayList<>();
        for (Pet pet : pets) {
            if (pet.getAdotado() == false) {
                disponiveis.add(new DadosDetalhesPetDTO(pet));
            }
        }
        return ResponseEntity.ok(disponiveis);
    }

}
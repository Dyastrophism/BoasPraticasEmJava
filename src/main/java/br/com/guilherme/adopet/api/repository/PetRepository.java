package br.com.guilherme.adopet.api.repository;

import br.com.guilherme.adopet.api.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {

}

package amarilla.cloud.petShop.service;

import amarilla.cloud.petShop.domain.model.Pet;

public interface PetService {
    Pet findById(Long id) throws NoSuchMethodException;
    Pet create(Pet pet);

}

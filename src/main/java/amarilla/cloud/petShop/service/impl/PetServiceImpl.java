package amarilla.cloud.petShop.service.impl;

import amarilla.cloud.petShop.domain.model.Pet;
import amarilla.cloud.petShop.domain.repository.PetRepository;
import amarilla.cloud.petShop.service.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet findById(Long id) throws NoSuchMethodException {
        return petRepository.findById(id).orElseThrow(NoSuchMethodException::new);
    }

    @Override
    public Pet create(Pet petToCreate) {
        if (petToCreate.getId() != null && petRepository.existsById(petToCreate.getId())){
            throw new IllegalArgumentException("This Pet ID is already registered");
        }
        if(petToCreate.getChip_id() != null && petRepository.existsBychip(petToCreate.getChip_id())){
            throw new IllegalArgumentException("This chip in pet is already registered, possibly stolen pet");
        }


        return this.petRepository.save(petToCreate);
    }
}

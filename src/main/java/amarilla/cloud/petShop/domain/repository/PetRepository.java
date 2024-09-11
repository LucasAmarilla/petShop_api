package amarilla.cloud.petShop.domain.repository;

import amarilla.cloud.petShop.domain.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    boolean existsBychip(Long id);
}

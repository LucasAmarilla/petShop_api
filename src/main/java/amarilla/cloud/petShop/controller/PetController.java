package amarilla.cloud.petShop.controller;

import amarilla.cloud.petShop.domain.model.Pet;
import amarilla.cloud.petShop.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService){
        this.petService = petService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> findById(@PathVariable Long id) throws NoSuchMethodException {
        var pet = petService.findById(id);
        return ResponseEntity.ok(pet);
    }

    @PostMapping()
    public ResponseEntity<Pet> create(@RequestBody Pet pet) {
        var petCreated = petService.create(pet);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(petCreated.getId()).toUri();

        return ResponseEntity.created(location).body(petCreated);
    }
}

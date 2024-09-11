package amarilla.cloud.petShop.domain.model;

import jakarta.persistence.*;


import java.util.List;
import java.util.Objects;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String species;
    private String race;

    @ManyToOne
    private Tutor tutor;
    @Column(unique = true)
    private Long chip;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Visits> VisitsList;



    public Pet(Long id, String name, String species, String race, Long chip_id) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.race = race;
        this.chip = chip_id;
    }

    public Pet() {
    }

    public List<Visits> getVisitsList() {
        return VisitsList;
    }

    public void setVisitsList(List<Visits> visitsList) {
        VisitsList = visitsList;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Long getChip_id() {
        return chip;
    }

    public void setChip_id(Long chip_id) {
        this.chip = chip_id;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", race='" + race + '\'' +
                ", chip_id=" + chip +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet pet)) return false;
        return Objects.equals(id, pet.id) && Objects.equals(name, pet.name) && Objects.equals(species, pet.species) && Objects.equals(race, pet.race) && Objects.equals(chip, pet.chip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, species, race, chip);
    }
}

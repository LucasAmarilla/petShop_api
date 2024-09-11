package amarilla.cloud.petShop.domain.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long name;
    private Long document;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Pet> pets;

    public Tutor() {
    }

    public Tutor(Long id, Long name, Long document, List<Pet> pets) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "id=" + id +
                ", name=" + name +
                ", document=" + document +
                ", pets=" + pets +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public Long getDocument() {
        return document;
    }

    public void setDocument(Long document) {
        this.document = document;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tutor tutor)) return false;
        return Objects.equals(id, tutor.id) && Objects.equals(name, tutor.name) && Objects.equals(document, tutor.document) && Objects.equals(pets, tutor.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, document, pets);
    }
}

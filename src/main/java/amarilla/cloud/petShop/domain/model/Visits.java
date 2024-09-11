package amarilla.cloud.petShop.domain.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Visits {
    private enum Type {
        Consulta,
        Banho,
        Cirugica
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String desc;
    @OneToOne
    private Profissional profissionalResponsavel;
    @Enumerated(EnumType.STRING)
    private Type visitType;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Visits() {
    }

    public Visits(Long id, String desc, Profissional profissionalResponsavel, Type visitType, Pet pet) {
        this.id = id;
        this.desc = desc;
        this.profissionalResponsavel = profissionalResponsavel;
        this.visitType = visitType;
        this.pet = pet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Profissional getProfissionalResponsavel() {
        return profissionalResponsavel;
    }

    public void setProfissionalResponsavel(Profissional profissionalResponsavel) {
        this.profissionalResponsavel = profissionalResponsavel;
    }

    public Type getVisitType() {
        return visitType;
    }

    public void setVisitType(Type visitType) {
        this.visitType = visitType;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Visits{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", profissionalResponsavel=" + profissionalResponsavel +
                ", visitType=" + visitType +
                ", pet=" + pet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visits visits)) return false;
        return Objects.equals(id, visits.id) && Objects.equals(desc, visits.desc) && Objects.equals(profissionalResponsavel, visits.profissionalResponsavel) && visitType == visits.visitType && Objects.equals(pet, visits.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, desc, profissionalResponsavel, visitType, pet);
    }
}

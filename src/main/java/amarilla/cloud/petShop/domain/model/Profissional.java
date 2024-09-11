package amarilla.cloud.petShop.domain.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;


@Entity
public class Profissional {
    private enum Cargo {
        VETERINARIO,
        TOSADOR,
        RECEPCIONISTA
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    private LocalDate date_joined;

    public Profissional() {
    }

    public Profissional(Long id, String name, Cargo cargo, LocalDate date_joined) {
        this.id = id;
        this.name = name;
        this.cargo = cargo;
        this.date_joined = date_joined;
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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public LocalDate getDate_joined() {
        return date_joined;
    }

    public void setDate_joined(LocalDate date_joined) {
        this.date_joined = date_joined;
    }

    @Override
    public String toString() {
        return "Profissional{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cargo=" + cargo +
                ", date_joined=" + date_joined +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profissional that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && cargo == that.cargo && Objects.equals(date_joined, that.date_joined);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cargo, date_joined);
    }
}

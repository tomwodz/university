package pl.tomwodz.university.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Entity
@Getter
@Setter
@Table(name="tlecturers")
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String surname;

    public Lecturer() {
    }

    public Lecturer(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public Lecturer(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}

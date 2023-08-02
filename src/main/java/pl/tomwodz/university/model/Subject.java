package pl.tomwodz.university.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Entity
@Getter
@Setter
@Table(name="tsubjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String name;

    public Subject() {
    }

    public Subject(String name)

    {
        this.name = name;
    }

    public Subject(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

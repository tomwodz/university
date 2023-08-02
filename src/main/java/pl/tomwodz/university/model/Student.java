package pl.tomwodz.university.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Entity
@Getter
@Setter
@Table(name="tstudents")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String surname;

    @Column(nullable = false)
    String faculty;

    @Column(nullable = false)
    String field;

    @Column(nullable = false)
    String groupStudents;

    @Column(nullable = false)
    String year;

    public Student() {
    }

    public Student(String name, String surname, String faculty, String field, String groupStudents, String year) {
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;
        this.field = field;
        this.groupStudents = groupStudents;
        this.year = year;
    }

    public Student(Long id, String name, String surname, String faculty, String field, String groupStudents, String year) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;
        this.field = field;
        this.groupStudents = groupStudents;
        this.year = year;
    }
}

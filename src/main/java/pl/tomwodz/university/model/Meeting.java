package pl.tomwodz.university.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Entity
@Getter
@Setter
@Table(name="tmeetings")
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    Long subject_id;

    @Column(nullable = false)
    Long lecturer_id;

    @Column(nullable = false)
    String group_students;

    public Meeting() {
    }

    public Meeting(Long subject_id, Long lecturer_id, String group_students) {
        this.subject_id = subject_id;
        this.lecturer_id = lecturer_id;
        this.group_students = group_students;
    }

    public Meeting(Long id, Long subject_id, Long lecturer_id, String group_students) {
        this.id = id;
        this.subject_id = subject_id;
        this.lecturer_id = lecturer_id;
        this.group_students = group_students;
    }
}

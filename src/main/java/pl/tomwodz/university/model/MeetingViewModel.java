package pl.tomwodz.university.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MeetingViewModel {
    Subject subject;
    Lecturer lecturer;
    List<Student> students;
}

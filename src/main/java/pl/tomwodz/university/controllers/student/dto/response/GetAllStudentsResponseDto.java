package pl.tomwodz.university.controllers.student.dto.response;
import pl.tomwodz.university.model.Student;
import java.util.List;

public record GetAllStudentsResponseDto(List<Student> students) {
}

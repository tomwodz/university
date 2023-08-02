package pl.tomwodz.university.controllers.student.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UpdateStudentRequestDto(
        @NotNull(message = "Student's name must not be null")
        @NotEmpty(message = "Student's  name must not be empty")
        String name,

        @NotNull(message = "Student's surname must not be null")
        @NotEmpty(message = "Student's surname must not be empty")
        String surname,

        @NotNull(message = "Student's faculty must not be null")
        @NotEmpty(message = "Student's faculty must not be empty")
        String faculty,
        @NotNull(message = "Student's field must not be null")
        @NotEmpty(message = "Student's field must not be empty")
        String field,

        @NotNull(message = "Student's group must not be null.")
        @NotEmpty(message = "Student's group must not be empty.")
        String groupStudents,

        @NotNull(message = "Student's year must not be null")
        @NotEmpty(message = "Student's year must not be empty")
        String year
) {
}

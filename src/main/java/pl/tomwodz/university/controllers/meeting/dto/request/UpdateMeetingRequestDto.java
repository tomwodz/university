package pl.tomwodz.university.controllers.meeting.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UpdateMeetingRequestDto(
        @NotNull(message = "Subject's ID must not be null")
        @NotEmpty(message = "Subject's ID must not be empty")
        Long subject_id,

        @NotNull(message = "Lecturer's ID must not be null")
        @NotEmpty(message = "Student's ID surname must not be empty")
        Long lecturer_id,

        @NotNull(message = "Student's group must not be null")
        @NotEmpty(message = "Student's group must not be empty")
        String group_students
) {
}

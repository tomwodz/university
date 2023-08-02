package pl.tomwodz.university.controllers.subject.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateSubjectRequestDto(
        @NotNull(message = "Subject name must not be null")
        @NotEmpty(message = "Subject  name must not be empty")
        String name
) {
}

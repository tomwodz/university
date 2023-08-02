package pl.tomwodz.university.controllers.subject.dto.response;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UpdateSubjectResponseDto(
        @NotNull(message = "Subject's name must not be null.")
        @NotEmpty(message = "Subject's name must not be empty.")
        String name) {
}

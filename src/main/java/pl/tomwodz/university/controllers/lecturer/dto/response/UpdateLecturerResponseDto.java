package pl.tomwodz.university.controllers.lecturer.dto.response;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UpdateLecturerResponseDto(
        @NotNull(message = "Lecturer's name must not be null.")
        @NotEmpty(message = "Lecturer's  name must not be empty.")
        String name,

        @NotNull(message = "Lecturer's surname must not be null.")
        @NotEmpty(message = "Lecturer's surname must not be empty.")
        String surname) {
}

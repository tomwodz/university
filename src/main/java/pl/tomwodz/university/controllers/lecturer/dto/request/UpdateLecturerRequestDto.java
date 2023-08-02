package pl.tomwodz.university.controllers.lecturer.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UpdateLecturerRequestDto(@NotNull(message = "Lecturer's name must not be null.")
                                       @NotEmpty(message = "Lecturer's  name must not be empty.")
                                       String name,

                                       @NotNull(message = "Lecturer's surname must not be null.")
                                       @NotEmpty(message = "Lecturer's surname must not be empty.")
                                       String surname) {
}

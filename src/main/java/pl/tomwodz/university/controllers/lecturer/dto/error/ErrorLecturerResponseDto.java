package pl.tomwodz.university.controllers.lecturer.dto.error;

import org.springframework.http.HttpStatus;

public record ErrorLecturerResponseDto(String message, HttpStatus status) {
}

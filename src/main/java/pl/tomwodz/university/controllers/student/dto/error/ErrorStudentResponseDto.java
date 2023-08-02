package pl.tomwodz.university.controllers.student.dto.error;

import org.springframework.http.HttpStatus;

public record ErrorStudentResponseDto(String message, HttpStatus status) {
}

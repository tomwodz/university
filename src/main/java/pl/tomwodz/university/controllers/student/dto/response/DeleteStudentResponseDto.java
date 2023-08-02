package pl.tomwodz.university.controllers.student.dto.response;

import org.springframework.http.HttpStatus;

public record DeleteStudentResponseDto(String message, HttpStatus status) {
}

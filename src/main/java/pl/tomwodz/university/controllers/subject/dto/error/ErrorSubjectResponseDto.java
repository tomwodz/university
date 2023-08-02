package pl.tomwodz.university.controllers.subject.dto.error;

import org.springframework.http.HttpStatus;

public record ErrorSubjectResponseDto(String message, HttpStatus status) {
}

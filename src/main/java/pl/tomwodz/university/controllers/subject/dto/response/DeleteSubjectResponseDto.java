package pl.tomwodz.university.controllers.subject.dto.response;

import org.springframework.http.HttpStatus;

public record DeleteSubjectResponseDto(String message, HttpStatus status) {
}

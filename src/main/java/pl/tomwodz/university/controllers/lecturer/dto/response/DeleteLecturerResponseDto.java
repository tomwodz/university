package pl.tomwodz.university.controllers.lecturer.dto.response;

import org.springframework.http.HttpStatus;

public record DeleteLecturerResponseDto(String message, HttpStatus status) {
}

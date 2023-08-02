package pl.tomwodz.university.controllers.meeting.dto.error;

import org.springframework.http.HttpStatus;

public record ErrorMeetingResponseDto(String message, HttpStatus status) {
}

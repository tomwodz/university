package pl.tomwodz.university.controllers.meeting.dto.response;

import org.springframework.http.HttpStatus;

public record DeleteMeetingResponseDto(String message, HttpStatus status) {
}

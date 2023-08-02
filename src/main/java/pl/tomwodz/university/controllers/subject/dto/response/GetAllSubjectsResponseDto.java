package pl.tomwodz.university.controllers.subject.dto.response;

import pl.tomwodz.university.model.Subject;

import java.util.List;

public record GetAllSubjectsResponseDto(List<Subject> subjects) {
}

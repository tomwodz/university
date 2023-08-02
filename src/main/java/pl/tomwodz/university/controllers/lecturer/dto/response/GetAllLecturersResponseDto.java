package pl.tomwodz.university.controllers.lecturer.dto.response;

import pl.tomwodz.university.model.Lecturer;

import java.util.List;

public record GetAllLecturersResponseDto(List<Lecturer> lecturers) {
}

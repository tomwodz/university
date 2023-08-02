package pl.tomwodz.university.controllers.lecturer;

import org.springframework.http.HttpStatus;
import pl.tomwodz.university.controllers.lecturer.dto.request.CreateLecturerRequestDto;
import pl.tomwodz.university.controllers.lecturer.dto.request.UpdateLecturerRequestDto;
import pl.tomwodz.university.controllers.lecturer.dto.response.*;
import pl.tomwodz.university.model.Lecturer;

import java.util.List;

public class LecturerMapper {
    public static GetAllLecturersResponseDto mapFromLecturerToGetAllLecturersResponseDto(List<Lecturer> lecturers) {
        return new GetAllLecturersResponseDto(lecturers);
    }

    public static GetLecturerResponseDto mapFromLecturerToGetResponseDto(Lecturer lecturer) {
        return new GetLecturerResponseDto(lecturer);
    }

    public static Lecturer mapFromCreateLecturerRequestDtoToLecturer(CreateLecturerRequestDto dto) {
        return new Lecturer(dto.name(),
                            dto.surname());
    }

    public static CreateLecturerResponseDto mapFromLecturerToCreateResponseDto(Lecturer lecturer) {
        return new CreateLecturerResponseDto(lecturer);
    }

    public static DeleteLecturerResponseDto mapFromLecturerToDeleteLecturerResponseDto(Long id) {
        return new DeleteLecturerResponseDto("You deleted Lecturer with id: " + id, HttpStatus.OK);
    }


    public static Lecturer mapFromUpDateLecturerRequestDtoToLecturer(UpdateLecturerRequestDto dto) {
        return new Lecturer(dto.name(), dto.surname());
    }

    public static UpdateLecturerResponseDto mapFromLecturerToUpdateLecturerResponseDto(Lecturer newLecturer) {
        return new UpdateLecturerResponseDto(newLecturer.getName(),
                newLecturer.getSurname());
    }
}

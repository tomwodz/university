package pl.tomwodz.university.controllers.subject;

import org.springframework.http.HttpStatus;
import pl.tomwodz.university.controllers.student.dto.response.UpdateStudentResponseDto;
import pl.tomwodz.university.controllers.subject.dto.request.CreateSubjectRequestDto;
import pl.tomwodz.university.controllers.subject.dto.request.UpdateSubjectRequestDto;
import pl.tomwodz.university.controllers.subject.dto.response.*;
import pl.tomwodz.university.model.Subject;

import java.util.List;

public class SubjectMapper {
    public static GetAllSubjectsResponseDto mapFromSubjectToGetAllSubjectsResponseDto(List<Subject> subjects) {
        return new GetAllSubjectsResponseDto(subjects);
    }
    public static GetSubjectResponseDto mapFromSubjectToGetResponseDto(Subject subject) {
        return new GetSubjectResponseDto(subject);
    }

    public static Subject mapFromCreateSubjectRequestDtoToSubject(CreateSubjectRequestDto dto) {
        return new Subject(dto.name());
    }

    public static CreateSubjectResponseDto mapFromSubjectToCreateResponseDto(Subject subject) {
        return new CreateSubjectResponseDto(subject);
    }

    public static DeleteSubjectResponseDto mapFromSubjectToDeleteSubjectResponseDto(Long id) {
        return new DeleteSubjectResponseDto("You deleted Subject with id: " + id, HttpStatus.OK);
    }

    public static Subject mapFromUpDateSubjectRequestDtoToSubject(UpdateSubjectRequestDto dto) {
        return new Subject(dto.name());
    }

    public static UpdateSubjectResponseDto mapFromSubjectToUpdateSubjectResponseDto(Subject newSubject) {
        return new UpdateSubjectResponseDto(newSubject.getName());
    }
}

package pl.tomwodz.university.controllers.student;

import org.springframework.http.HttpStatus;
import pl.tomwodz.university.controllers.meeting.dto.response.GetMeetingResponseDto;
import pl.tomwodz.university.controllers.student.dto.request.CreateStudentRequestDto;
import pl.tomwodz.university.controllers.student.dto.request.UpdateStudentRequestDto;
import pl.tomwodz.university.controllers.student.dto.response.DeleteStudentResponseDto;
import pl.tomwodz.university.controllers.student.dto.response.GetAllStudentsResponseDto;
import pl.tomwodz.university.controllers.student.dto.response.GetStudentResponseDto;
import pl.tomwodz.university.controllers.student.dto.response.UpdateStudentResponseDto;
import pl.tomwodz.university.model.Meeting;
import pl.tomwodz.university.model.MeetingViewModel;
import pl.tomwodz.university.model.Student;
import pl.tomwodz.university.controllers.student.dto.response.CreateStudentResponseDto;

import java.util.List;

public class StudentMapper {

    public static GetAllStudentsResponseDto mapFromStudentToGetAllStudentsResponseDto(List<Student> students){
        return new GetAllStudentsResponseDto(students);
    }
    public static GetStudentResponseDto mapFromStudentToGetResponseDto(Student student) {
        return new GetStudentResponseDto(student);
    }

    public static Student mapFromCreateStudentRequestDtoToStudent(CreateStudentRequestDto dto) {
        return new Student(
                dto.name(),
                dto.surname(),
                dto.faculty(),
                dto.field(),
                dto.groupStudents(),
                dto.year()
        );
    }

    public static CreateStudentResponseDto mapFromStudentToCreateResponseDto(Student student) {
        return new CreateStudentResponseDto(student);
    }

    public static DeleteStudentResponseDto mapFromStudentToDeleteStudentResponseDto(Long id) {
        return new DeleteStudentResponseDto("You deleted Student with id: " + id, HttpStatus.OK);
    }

    public static Student mapFromUpDateStudnetRequestDtoToStudent(UpdateStudentRequestDto dto) {
        return new Student(
                dto.name(),
                dto.surname(),
                dto.faculty(),
                dto.field(),
                dto.groupStudents(),
                dto.year()
        );
    }

    public static UpdateStudentResponseDto mapFromStudentToUpdateStudentResponseDto(Student newStudent) {
        return new UpdateStudentResponseDto(
                newStudent.getName(),
                newStudent.getSurname(),
                newStudent.getFaculty(),
                newStudent.getField(),
                newStudent.getGroupStudents(),
                newStudent.getYear());
    }

    public static GetMeetingResponseDto mapFromMeetingToGetResponseDto(Meeting meeting) {
        return new GetMeetingResponseDto(meeting);
    }


}

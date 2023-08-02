package pl.tomwodz.university.controllers.student;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.tomwodz.university.controllers.student.dto.request.CreateStudentRequestDto;
import pl.tomwodz.university.controllers.student.dto.request.UpdateStudentRequestDto;
import pl.tomwodz.university.controllers.student.dto.response.DeleteStudentResponseDto;
import pl.tomwodz.university.controllers.student.dto.response.GetAllStudentsResponseDto;
import pl.tomwodz.university.controllers.student.dto.response.GetStudentResponseDto;
import pl.tomwodz.university.controllers.student.dto.response.UpdateStudentResponseDto;
import pl.tomwodz.university.model.Student;
import pl.tomwodz.university.services.IStudentService;
import pl.tomwodz.university.controllers.student.dto.response.CreateStudentResponseDto;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("university/students")
public class StudentRestController {

    private final IStudentService studentService;

    public StudentRestController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public ResponseEntity<GetAllStudentsResponseDto> getAllStudents(@RequestParam(required = false) Integer limit){
        List<Student> allStudents = studentService.findAll();
        if (limit != null) {
            List<Student>  limitedMap = studentService.findAllLimitedBy(limit);
            GetAllStudentsResponseDto response = StudentMapper.mapFromStudentToGetAllStudentsResponseDto(limitedMap);
            return ResponseEntity.ok(response);
        }
        GetAllStudentsResponseDto response = StudentMapper.mapFromStudentToGetAllStudentsResponseDto(allStudents);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetStudentResponseDto> getStudentById(@PathVariable Long id) {
        log.info("Request Student By ID: " + id);
        Student student = studentService.findById(id);
        GetStudentResponseDto response = StudentMapper.mapFromStudentToGetResponseDto(student);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateStudentResponseDto> postStudent(@RequestBody @Valid CreateStudentRequestDto request) {
        Student student = StudentMapper.mapFromCreateStudentRequestDtoToStudent(request);
        studentService.add(student);
        CreateStudentResponseDto body = StudentMapper.mapFromStudentToCreateResponseDto(student);
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteStudentResponseDto> deleteStudentByIdUsingPathVariable(@PathVariable Long id) {
        studentService.deleteById(id);
        DeleteStudentResponseDto body = StudentMapper.mapFromStudentToDeleteStudentResponseDto(id);
        return ResponseEntity.ok(body);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateStudentResponseDto> updateStudentById(@PathVariable Long id,
                                                           @RequestBody @Valid UpdateStudentRequestDto request){
        Student newStudent = StudentMapper.mapFromUpDateStudnetRequestDtoToStudent(request);
        studentService.updateById(id, newStudent);
        UpdateStudentResponseDto body = StudentMapper.mapFromStudentToUpdateStudentResponseDto(newStudent);
        return ResponseEntity.ok(body);
    }

}

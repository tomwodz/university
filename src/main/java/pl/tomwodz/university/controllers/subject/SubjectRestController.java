package pl.tomwodz.university.controllers.subject;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.tomwodz.university.controllers.student.StudentMapper;
import pl.tomwodz.university.controllers.student.dto.response.UpdateStudentResponseDto;
import pl.tomwodz.university.controllers.subject.dto.request.CreateSubjectRequestDto;
import pl.tomwodz.university.controllers.subject.dto.request.UpdateSubjectRequestDto;
import pl.tomwodz.university.controllers.subject.dto.response.*;
import pl.tomwodz.university.model.Subject;
import pl.tomwodz.university.services.ISubjectService;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("university/subjects")
public class SubjectRestController {

    private final ISubjectService subjectService;

    public SubjectRestController(ISubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/")
    public ResponseEntity<GetAllSubjectsResponseDto> getAllSubjects(@RequestParam(required = false) Integer limit){
        List<Subject> allSubjects = subjectService.findAll();
        if (limit != null) {
            List<Subject>  limitedMap = subjectService.findAllLimitedBy(limit);
            GetAllSubjectsResponseDto response = SubjectMapper.mapFromSubjectToGetAllSubjectsResponseDto(limitedMap);
            return ResponseEntity.ok(response);
        }
        GetAllSubjectsResponseDto response = SubjectMapper.mapFromSubjectToGetAllSubjectsResponseDto(allSubjects);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetSubjectResponseDto> getSubjectById(@PathVariable Long id) {
        log.info("Request Subject By ID: " + id);
        Subject subject = subjectService.findById(id);
        GetSubjectResponseDto response = SubjectMapper.mapFromSubjectToGetResponseDto(subject);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateSubjectResponseDto> postSubject(@RequestBody @Valid CreateSubjectRequestDto request) {
        Subject subject = SubjectMapper.mapFromCreateSubjectRequestDtoToSubject(request);
        subjectService.add(subject);
        CreateSubjectResponseDto body = SubjectMapper.mapFromSubjectToCreateResponseDto(subject);
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteSubjectResponseDto> deleteSubjectByIdUsingPathVariable(@PathVariable Long id) {
        subjectService.deleteById(id);
        DeleteSubjectResponseDto body = SubjectMapper.mapFromSubjectToDeleteSubjectResponseDto(id);
        return ResponseEntity.ok(body);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateSubjectResponseDto> updateStudentById(@PathVariable Long id,
                                                                      @RequestBody @Valid UpdateSubjectRequestDto request){
        Subject newSubject = SubjectMapper.mapFromUpDateSubjectRequestDtoToSubject(request);
        subjectService.updateById(id, newSubject);
        log.info("Updated Subject with id: " + id);
        UpdateSubjectResponseDto body = SubjectMapper.mapFromSubjectToUpdateSubjectResponseDto(newSubject);
        return ResponseEntity.ok(body);
    }

}

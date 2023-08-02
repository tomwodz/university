package pl.tomwodz.university.controllers.lecturer;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.tomwodz.university.controllers.lecturer.dto.request.CreateLecturerRequestDto;
import pl.tomwodz.university.controllers.lecturer.dto.request.UpdateLecturerRequestDto;
import pl.tomwodz.university.controllers.lecturer.dto.response.*;
import pl.tomwodz.university.model.Lecturer;
import pl.tomwodz.university.services.ILecturerService;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("university/lecturer")
public class LecturerRestController {

    private final ILecturerService lecturerService;

    public LecturerRestController(ILecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @GetMapping("/")
    public ResponseEntity<GetAllLecturersResponseDto> getAllLecturers(@RequestParam(required = false) Integer limit){
        List<Lecturer> allLecturers = lecturerService.findAll();
        if (limit != null) {
            List<Lecturer>  limitedMap = lecturerService.findAllLimitedBy(limit);
            GetAllLecturersResponseDto response = LecturerMapper.mapFromLecturerToGetAllLecturersResponseDto(limitedMap);
            return ResponseEntity.ok(response);
        }
        GetAllLecturersResponseDto response = LecturerMapper.mapFromLecturerToGetAllLecturersResponseDto(allLecturers);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetLecturerResponseDto> getLecturerById(@PathVariable Long id) {
        log.info("Request Lecturer By ID: " + id);
        Lecturer lecturer = lecturerService.findById(id);
        GetLecturerResponseDto response = LecturerMapper.mapFromLecturerToGetResponseDto(lecturer);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateLecturerResponseDto> postLecturer(@RequestBody @Valid CreateLecturerRequestDto request) {
        Lecturer lecturer = LecturerMapper.mapFromCreateLecturerRequestDtoToLecturer(request);
        lecturerService.add(lecturer);
        CreateLecturerResponseDto body = LecturerMapper.mapFromLecturerToCreateResponseDto(lecturer);
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteLecturerResponseDto> deleteLecturerByIdUsingPathVariable(@PathVariable Long id) {
        lecturerService.deleteById(id);
        DeleteLecturerResponseDto body = LecturerMapper.mapFromLecturerToDeleteLecturerResponseDto(id);
        return ResponseEntity.ok(body);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateLecturerResponseDto> updateLecturerById(@PathVariable Long id,
                                                                        @RequestBody @Valid UpdateLecturerRequestDto request){
        Lecturer newLecturer =  LecturerMapper.mapFromUpDateLecturerRequestDtoToLecturer(request);
        lecturerService.updateById(id, newLecturer);
        log.info("Updated Student with id: " + id);
        UpdateLecturerResponseDto body = LecturerMapper.mapFromLecturerToUpdateLecturerResponseDto(newLecturer);
        return ResponseEntity.ok(body);
    }
}

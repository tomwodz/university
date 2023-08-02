package pl.tomwodz.university.controllers.student.dto.error;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.tomwodz.university.controllers.student.StudentRestController;
import pl.tomwodz.university.model.exception.StudentNotFoundException;

@ControllerAdvice(assignableTypes = StudentRestController.class)
@Log4j2
public class StudentErrorHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorStudentResponseDto handleException(StudentNotFoundException exception){
        log.warn("StudentNotFoundException error while accessing student");
        return new ErrorStudentResponseDto(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}

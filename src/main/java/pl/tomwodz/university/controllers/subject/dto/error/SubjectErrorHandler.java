package pl.tomwodz.university.controllers.subject.dto.error;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.tomwodz.university.controllers.subject.SubjectRestController;
import pl.tomwodz.university.model.exception.SubjectNotFoundException;

@ControllerAdvice(assignableTypes = SubjectRestController.class)
@Log4j2
public class SubjectErrorHandler {

    @ExceptionHandler(SubjectNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorSubjectResponseDto handleException(SubjectNotFoundException exception){
        log.warn("SubjectNotFoundException error while accessing student");
        return new ErrorSubjectResponseDto(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}

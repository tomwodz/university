package pl.tomwodz.university.controllers.lecturer.dto.error;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.tomwodz.university.controllers.lecturer.LecturerRestController;
import pl.tomwodz.university.model.exception.LecturerNotFoundException;

@ControllerAdvice(assignableTypes = LecturerRestController.class)
@Log4j2
public class LecturerErrorHandler {

    @ExceptionHandler(LecturerNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorLecturerResponseDto handleException(LecturerNotFoundException exception){
        log.warn("LecturerNotFoundException error while accessing lecturer");
        return new ErrorLecturerResponseDto(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}

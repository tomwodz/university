package pl.tomwodz.university.controllers.meeting.dto.error;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.tomwodz.university.controllers.meeting.MeetingRestController;
import pl.tomwodz.university.model.exception.LecturerNotFoundException;
import pl.tomwodz.university.model.exception.MeetingNotFoundException;
import pl.tomwodz.university.model.exception.SubjectNotFoundException;

@ControllerAdvice(assignableTypes = MeetingRestController.class)
@Log4j2
public class MeetingErrorHandler {

    @ExceptionHandler(MeetingNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMeetingResponseDto handleException(MeetingNotFoundException exception){
        log.warn("MeetingNotFoundException error while accessing ");
        return new ErrorMeetingResponseDto(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SubjectNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMeetingResponseDto handleException(SubjectNotFoundException exception){
        log.warn("SubjectNotFoundException error while accessing ");
        return new ErrorMeetingResponseDto(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LecturerNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMeetingResponseDto handleException(LecturerNotFoundException exception){
        log.warn("LecturerNotFoundException error while accessing ");
        return new ErrorMeetingResponseDto(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}

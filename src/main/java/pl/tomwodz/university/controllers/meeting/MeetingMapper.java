package pl.tomwodz.university.controllers.meeting;

import org.springframework.http.HttpStatus;
import pl.tomwodz.university.controllers.meeting.dto.request.CreateMeetingRequestDto;
import pl.tomwodz.university.controllers.meeting.dto.request.UpdateMeetingRequestDto;
import pl.tomwodz.university.controllers.meeting.dto.response.*;
import pl.tomwodz.university.model.Meeting;
import pl.tomwodz.university.model.MeetingViewModel;

import java.util.List;

public class MeetingMapper {
    public static GetAllMeetingsViewModelResponseDto mapFromMeetingToGetAllMeetingsViewModelResponseDto(List<MeetingViewModel> allMeetings) {
        return new GetAllMeetingsViewModelResponseDto(allMeetings);
    }

    public static Meeting mapFromCreateMeetingRequestDtoToMeeting(CreateMeetingRequestDto dto) {
        Long subject_id = dto.subject_id();
        Long lecturer_id = dto.lecturer_id();
        String group_students = dto.group_students();
        return new Meeting(subject_id, lecturer_id, group_students);
    }

    public static CreateMeetingResponseDto mapFromMeetingToCreateResponseDto(Meeting meeting) {
        return new CreateMeetingResponseDto(meeting);
    }

    public static DeleteMeetingResponseDto mapFromSMeetingToDeleteMeetingResponseDto(Long id) {
        return new DeleteMeetingResponseDto("You deleted Meeting with id: " + id, HttpStatus.OK);
    }

    public static Meeting mapFromUpDateMeetingRequestDtoToMeeting(UpdateMeetingRequestDto dto) {
        Long subject_id = dto.subject_id();
        Long lecturer_id = dto.lecturer_id();
        String group_students = dto.group_students();
        return new Meeting(subject_id, lecturer_id, group_students);
    }

    public static UpdateMeetingResponseDto mapFromMeetingToUpdateMeetingResponseDto(Meeting newMeeting) {
        return new UpdateMeetingResponseDto(newMeeting);
    }

    public static GetMeetingViewModelResponseDto mapFromMeetingViewModelToGetResponseDto(MeetingViewModel meetingViewModel) {
        return new GetMeetingViewModelResponseDto(meetingViewModel);
    }
}

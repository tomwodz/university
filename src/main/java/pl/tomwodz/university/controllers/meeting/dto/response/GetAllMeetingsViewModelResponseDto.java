package pl.tomwodz.university.controllers.meeting.dto.response;

import pl.tomwodz.university.model.MeetingViewModel;

import java.util.List;

public record GetAllMeetingsViewModelResponseDto(List<MeetingViewModel> meetings) {
}

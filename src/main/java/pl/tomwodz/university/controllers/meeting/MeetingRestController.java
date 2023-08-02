package pl.tomwodz.university.controllers.meeting;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.tomwodz.university.controllers.meeting.dto.request.CreateMeetingRequestDto;
import pl.tomwodz.university.controllers.meeting.dto.request.UpdateMeetingRequestDto;
import pl.tomwodz.university.controllers.meeting.dto.response.*;
import pl.tomwodz.university.controllers.student.StudentMapper;
import pl.tomwodz.university.model.Meeting;
import pl.tomwodz.university.model.MeetingViewModel;
import pl.tomwodz.university.services.IMeetingService;
import pl.tomwodz.university.services.IMeetingViewModelService;


import java.util.List;

@RestController
@Log4j2
@RequestMapping("university/meeting")
public class MeetingRestController {
 private final IMeetingViewModelService meetingViewModelService;

 private final IMeetingService meetingService;

    public MeetingRestController(IMeetingViewModelService meetingViewModelService, IMeetingService meetingService) {
        this.meetingViewModelService = meetingViewModelService;
        this.meetingService = meetingService;
    }

    @GetMapping("/view")
    public ResponseEntity<GetAllMeetingsViewModelResponseDto> getAllMeetings(){
        List<MeetingViewModel> allMeetingsViewModel = meetingViewModelService.findAll();
        GetAllMeetingsViewModelResponseDto response = MeetingMapper.mapFromMeetingToGetAllMeetingsViewModelResponseDto(allMeetingsViewModel);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<GetMeetingViewModelResponseDto> getMeetingViewModelById(@PathVariable Long id) {
        log.info("Request MeetingViewModel By ID: " + id);
        MeetingViewModel meetingViewModel = meetingViewModelService.findById(id);
        GetMeetingViewModelResponseDto response = MeetingMapper.mapFromMeetingViewModelToGetResponseDto(meetingViewModel);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetMeetingResponseDto> getMeetingById(@PathVariable Long id) {
        log.info("Request Meeting By ID: " + id);
        Meeting meeting = meetingService.findById(id);
        GetMeetingResponseDto response = StudentMapper.mapFromMeetingToGetResponseDto(meeting);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateMeetingResponseDto> postMeeting(@RequestBody CreateMeetingRequestDto request) {
        Meeting meeting = MeetingMapper.mapFromCreateMeetingRequestDtoToMeeting(request);
        meetingService.add(meeting);
        CreateMeetingResponseDto body = MeetingMapper.mapFromMeetingToCreateResponseDto(meeting);
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteMeetingResponseDto> deleteMeetingByIdUsingPathVariable(@PathVariable Long id) {
        meetingService.deleteById(id);
        DeleteMeetingResponseDto body = MeetingMapper.mapFromSMeetingToDeleteMeetingResponseDto(id);
        return ResponseEntity.ok(body);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateMeetingResponseDto> updateMeetingById(@PathVariable Long id,
                                                                      @RequestBody UpdateMeetingRequestDto request){
        Meeting newMeeting = MeetingMapper.mapFromUpDateMeetingRequestDtoToMeeting(request);
        meetingService.updateById(id, newMeeting);
        UpdateMeetingResponseDto body = MeetingMapper.mapFromMeetingToUpdateMeetingResponseDto(newMeeting);
        return ResponseEntity.ok(body);
    }


}

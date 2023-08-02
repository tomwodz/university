package pl.tomwodz.university.services.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.tomwodz.university.model.Meeting;
import pl.tomwodz.university.model.MeetingViewModel;
import pl.tomwodz.university.model.Student;
import pl.tomwodz.university.services.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Log4j2
@Service
public class MeetingViewModelService implements IMeetingViewModelService {

    private final IMeetingService meetingService;
    private final ISubjectService subjectService;
    private final ILecturerService lecturerService;
    private final IStudentService studentService;

    public MeetingViewModelService(IMeetingService meetingService, ISubjectService subjectService, ILecturerService lecturerService, IStudentService studentService) {
        this.meetingService = meetingService;
        this.subjectService = subjectService;
        this.lecturerService = lecturerService;
        this.studentService = studentService;
    }

    @Override
    public List<MeetingViewModel> findAll() {
        List<MeetingViewModel> meetingViewModels = new ArrayList<>();
        List<Meeting> meetings = meetingService.findAll();
        if(meetings.size()>0) {
            for (int i = 0; i < meetings.size(); i++) {
                meetingViewModels.add(new MeetingViewModel(
                        subjectService.findById(meetings.get(i).getSubject_id()),
                        lecturerService.findById(meetings.get(i).getLecturer_id()),
                        studentService.findByGroup(meetings.get(i).getGroup_students())
                ));
            }
        }
        else {
            return Collections.emptyList();
        }
        return meetingViewModels;
    }

    @Override
    public MeetingViewModel findById(Long id) {
        meetingService.existsById(id);
        Meeting meeting = meetingService.findById(id);
        MeetingViewModel meetingViewModel =
                new MeetingViewModel(
                subjectService.findById(meeting.getSubject_id()),
                lecturerService.findById(meeting.getLecturer_id()),
                studentService.findByGroup(meeting.getGroup_students())
        );
        return meetingViewModel;
    }
}

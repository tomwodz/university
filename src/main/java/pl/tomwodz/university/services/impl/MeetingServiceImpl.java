package pl.tomwodz.university.services.impl;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.tomwodz.university.database.IMeetingRepository;
import pl.tomwodz.university.model.Meeting;
import pl.tomwodz.university.model.exception.MeetingNotFoundException;
import pl.tomwodz.university.services.ILecturerService;
import pl.tomwodz.university.services.IMeetingService;
import pl.tomwodz.university.services.ISubjectService;

import java.util.List;

@Log4j2
@Service
@Transactional
public class MeetingServiceImpl implements IMeetingService {

    private  final IMeetingRepository meetingRepository;
    private final ILecturerService lecturerService;
    private final ISubjectService subjectService;

    public MeetingServiceImpl(IMeetingRepository meetingRepository, ILecturerService lecturerService, ISubjectService subjectService) {
        this.meetingRepository = meetingRepository;
        this.lecturerService = lecturerService;
        this.subjectService = subjectService;
    }

    @Override
    public List<Meeting> findAll() {
        return meetingRepository.findAll();
    }

    @Override
    public Meeting findById(Long id) {
        return meetingRepository.findById(id).
                orElseThrow(() -> new MeetingNotFoundException("Meeting with id " + id + " not found."));
    }

    @Override
    public void existsById(Long id) {
        if (!meetingRepository.existsById(id)) {
            throw new MeetingNotFoundException("Meeting with id " + id + " not found.");
        }
    }

    @Override
    public Meeting add(Meeting meeting) {
        subjectService.existsById(meeting.getSubject_id());
        lecturerService.existsById(meeting.getLecturer_id());
        return meetingRepository.save(meeting);
    }

    @Override
    public void deleteById(Long id) {
        existsById(id);
        log.info("deleting Meeting by id: " + id);
        meetingRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id, Meeting newMeeting) {
        existsById(id);
        subjectService.existsById(newMeeting.getSubject_id());
        lecturerService.existsById(newMeeting.getLecturer_id());
        meetingRepository.updateById(id, newMeeting);
    }
}

package pl.tomwodz.university.services;
import pl.tomwodz.university.model.Meeting;


import java.util.List;

public interface IMeetingService {

    List<Meeting> findAll();

    void existsById(Long id);
    Meeting add(Meeting meeting);

    void deleteById(Long id);

    Meeting findById(Long id);

    void updateById(Long id, Meeting newMeeting);
}

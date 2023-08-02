package pl.tomwodz.university.services;

import pl.tomwodz.university.model.MeetingViewModel;

import java.util.List;

public interface IMeetingViewModelService {

    List<MeetingViewModel> findAll();

    MeetingViewModel findById(Long id);
}

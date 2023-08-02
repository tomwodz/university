package pl.tomwodz.university.services;
import pl.tomwodz.university.model.Lecturer;

import java.util.List;

public interface ILecturerService {
    List<Lecturer> findAll();

    List<Lecturer> findAllLimitedBy(Integer limit);

    Lecturer findById(Long id);

    void existsById(Long id);

    Lecturer add(Lecturer lecturer);

    void deleteById(Long id);

    void updateById(Long id, Lecturer newLecturer);
}

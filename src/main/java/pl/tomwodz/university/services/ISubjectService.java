package pl.tomwodz.university.services;
import pl.tomwodz.university.model.Subject;

import java.util.List;

public interface ISubjectService {
    List<Subject> findAll();

    List<Subject> findAllLimitedBy(Integer limit);

    Subject findById(Long id);

    void existsById(Long id);
    Subject add(Subject subject);

    void deleteById(Long id);

    void updateById(Long id, Subject newSubject);
}

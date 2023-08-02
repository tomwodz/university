package pl.tomwodz.university.services.impl;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.tomwodz.university.database.ISubjectRepository;
import pl.tomwodz.university.model.Subject;
import pl.tomwodz.university.model.exception.SubjectNotFoundException;
import pl.tomwodz.university.services.ISubjectService;

import java.util.List;

@Log4j2
@Service
@Transactional
public class SubjectServiceImpl implements ISubjectService {

    private final ISubjectRepository subjectRepository;

    public SubjectServiceImpl(ISubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> findAll() {
        log.info("retrieving all Subjects: ");
        return subjectRepository.findAll();
    }

    @Override
    public List<Subject> findAllLimitedBy(Integer limit) {
        log.info("retrieving all Subjects with limit: " + limit);
        return subjectRepository.findAll()
                .stream()
                .limit(limit)
                .toList();
    }

    @Override
    public Subject findById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new SubjectNotFoundException("Subject with id " + id + " not found."));
    }

    @Override
    public void existsById(Long id) {
        if (!subjectRepository.existsById(id)) {
            throw new SubjectNotFoundException("Subject with id " + id + " not found.");
        }
    }

    @Override
    public Subject add(Subject subject) {
        log.info("adding new Subject: " + subject.getName());
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteById(Long id) {
        existsById(id);
        log.info("deleting Subject by id: " + id);
        subjectRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id, Subject newSubject) {
        existsById(id);
        subjectRepository.updateById(id, newSubject);
    }
}

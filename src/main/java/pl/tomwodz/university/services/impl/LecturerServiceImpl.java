package pl.tomwodz.university.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.tomwodz.university.database.ILecturerRepository;
import pl.tomwodz.university.model.Lecturer;
import pl.tomwodz.university.model.exception.LecturerNotFoundException;
import pl.tomwodz.university.services.ILecturerService;

import java.util.List;

@Log4j2
@Service
@Transactional
public class LecturerServiceImpl implements ILecturerService {

    private final ILecturerRepository lecturerRepository;

    public LecturerServiceImpl(ILecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    @Override
    public List<Lecturer> findAll() {
        log.info("retrieving all Lecturer: ");
        return lecturerRepository.findAll();
    }

    @Override
    public List<Lecturer> findAllLimitedBy(Integer limit) {
        log.info("retrieving all Lecturer with limit: " + limit);
        return lecturerRepository.findAll()
                .stream()
                .limit(limit)
                .toList();
    }

    @Override
    public Lecturer findById(Long id) {
        return lecturerRepository.findById(id)
                .orElseThrow(() -> new LecturerNotFoundException("Lecturer with id " + id + " not found."));
    }

    @Override
    public void existsById(Long id) {
        if (!lecturerRepository.existsById(id)) {
            throw new LecturerNotFoundException("Lecturer with id " + id + " not found.");
        }
    }

    @Override
    public Lecturer add(Lecturer lecturer) {
        log.info("adding new Lecturer: " + lecturer.getName() + " " + lecturer.getSurname());
        return lecturerRepository.save(lecturer);
    }

    @Override
    public void deleteById(Long id) {
        existsById(id);
        log.info("deleting Lecturer by id: " + id);
        lecturerRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id, Lecturer newLecturer) {
        existsById(id);
        lecturerRepository.updateById(id, newLecturer);
    }
}

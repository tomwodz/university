package pl.tomwodz.university.services.impl;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.tomwodz.university.database.IStudentRepository;
import pl.tomwodz.university.model.Student;
import pl.tomwodz.university.model.exception.StudentNotFoundException;
import pl.tomwodz.university.services.IStudentService;

import java.util.List;

@Log4j2
@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

    private final IStudentRepository studentRepository;

    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll(){
        log.info("retrieving all Students: ");
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findAllLimitedBy(Integer limit) {
        log.info("retrieving all Students with limit: " + limit);
        return studentRepository.findAll()
                .stream()
                .limit(limit)
                .toList();
    }

    @Override
    public Student findById(Long id){
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found."));
    }

    @Override
    public List<Student> findByGroup(String group) {
        log.info("retrieving all Students with group: " + group);
        return studentRepository.findAll()
                .stream()
                .filter(s -> s.getGroupStudents().equals(group))
                .toList();
    }


    @Override
    public void existsById(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student with id " + id + " not found.");
        }
    }

    @Override
    public Student add(Student student) {
        log.info("adding new Student: " + student.getName() + " " + student.getSurname());
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        existsById(id);
        log.info("deleting Student by id: " + id);
        studentRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id, Student newStudent) {
        existsById(id);
        studentRepository.updateById(id, newStudent);
        log.info("Updated Student with id: " + id);
    }
}

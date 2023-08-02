package pl.tomwodz.university.services;

import pl.tomwodz.university.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    List<Student> findAllLimitedBy(Integer limit);

    Student findById(Long id);

    void existsById(Long id);

    List<Student> findByGroup(String group);

    Student add(Student student);

    void deleteById(Long id);

    void updateById(Long id, Student newStudent);
}

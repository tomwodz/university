package pl.tomwodz.university.database;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pl.tomwodz.university.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentRepository extends Repository<Student, Long> {

    @Query("SELECT s FROM Student s")
    List<Student> findAll();

    @Query("SELECT s FROM Student s WHERE  s.id =:id")
    Optional<Student> findById(Long id);

    Student save(Student student);

    boolean existsById(Long id);


    @Modifying
    @Query("DELETE FROM Student s WHERE s.id = :id")
    void deleteById(Long id);


    @Modifying
    @Query("UPDATE Student s SET s.name = :#{#newStudent.name}, s.surname = :#{#newStudent.surname}, s.faculty = :#{#newStudent.faculty},  s.field = :#{#newStudent.field}, s.groupStudents= :#{#newStudent.groupStudents}, s.year = :#{#newStudent.year} WHERE s.id = :id")
    void updateById(Long id, Student newStudent);


}
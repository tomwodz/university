package pl.tomwodz.university.database;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pl.tomwodz.university.model.Subject;

import java.util.List;
import java.util.Optional;

public interface ISubjectRepository extends Repository<Subject, Long> {

    @Query("SELECT su FROM Subject su")
    List<Subject> findAll();

    @Query("SELECT su FROM Subject su WHERE  su.id =:id")
    Optional<Subject> findById(Long id);

    Subject save(Subject subject);

    boolean existsById(Long id);

    @Modifying
    @Query("DELETE FROM Subject su WHERE su.id = :id")
    void deleteById(Long id);

    @Modifying
    @Query("UPDATE Subject su SET su.name = :#{#newSubject.name} WHERE su.id = :id")
    void updateById(Long id, Subject newSubject);
}

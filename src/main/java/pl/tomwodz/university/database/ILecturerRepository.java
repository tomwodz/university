package pl.tomwodz.university.database;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pl.tomwodz.university.model.Lecturer;

import java.util.List;
import java.util.Optional;

public interface ILecturerRepository extends Repository<Lecturer, Long> {

    @Query("SELECT l FROM Lecturer l")
    List<Lecturer> findAll();

    @Query("SELECT l FROM Lecturer l WHERE  l.id =:id")
    Optional<Lecturer> findById(Long id);

    Lecturer save(Lecturer lecturer);

    boolean existsById(Long id);

    @Modifying
    @Query("DELETE FROM Lecturer l WHERE l.id = :id")
    void deleteById(Long id);

    @Modifying
    @Query("UPDATE Lecturer l SET l.name = :#{#newLecturer.name}, l.surname = :#{#newLecturer.surname} WHERE l.id = :id")
    void updateById(Long id, Lecturer newLecturer);
}

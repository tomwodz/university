package pl.tomwodz.university.database;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pl.tomwodz.university.model.Meeting;

import java.util.List;
import java.util.Optional;

public interface IMeetingRepository extends Repository<Meeting,Long> {

    @Query("SELECT m FROM Meeting m")
    List<Meeting> findAll();

    @Query("SELECT m FROM Meeting m WHERE  m.id =:id")
    Optional<Meeting> findById(Long id);
    Meeting save(Meeting meeting);

    boolean existsById(Long id);

    @Modifying
    @Query("DELETE FROM Meeting m WHERE m.id = :id")
    void deleteById(Long id);

    @Modifying
    @Query("UPDATE Meeting m SET m.subject_id = :#{#newMeeting.subject_id}, m.lecturer_id = :#{#newMeeting.lecturer_id}, m.group_students = :#{#newMeeting.group_students} WHERE m.id = :id")
    void updateById(Long id, Meeting newMeeting);

}

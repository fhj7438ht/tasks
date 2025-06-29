package task4_13.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import task4_13.dto.Message;

import java.time.LocalDateTime;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Message m SET " +
            "m.title = COALESCE(:title, m.title), " +
            "m.text = COALESCE(:text, m.text), " +
            "m.time = COALESCE(:time, m.time) " +
            "WHERE m.id = :id")
    void updateMessageById(Integer id, String title, String text, LocalDateTime time);
}
package task4_13.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import task4_13.dto.Person;

import java.time.LocalDate;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Person p SET " +
            "p.firstname = COALESCE(:firstname, p.firstname), " +
            "p.surname = COALESCE(:surname, p.surname), " +
            "p.lastname = COALESCE(:lastname, p.lastname), " +
            "p.birthday = COALESCE(:birthday, p.birthday) " +
            "WHERE p.id = :id")
    void updatePersonById(Integer id, String firstname, String surname, String lastname, LocalDate birthday);
}

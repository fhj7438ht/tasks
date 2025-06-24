package task4_13.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import task4_13.dto.Person;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final List<Person> persons = new ArrayList<>(Arrays.asList(
            new Person(1, "Ivan", "Ivanovich", "Ivanov", LocalDate.of(1999, 2, 3)),
            new Person(2, "Петр", "Петрович", "Петров", LocalDate.of(2002, 2, 2)),
            new Person(3, "Евгений", "Васильевич", "Васин", LocalDate.of(2005, 4, 8)),
            new Person(4, "Максим", "Яковлевич", "Окопский", LocalDate.of(1978, 6, 5))
    ));

    @GetMapping
    public List<Person> getPersons() {
        return persons;
    }

    @GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable int id) {
        return persons.stream().filter(p -> p.getId() == id).findFirst();
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        persons.add(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person person) {
        int index = -1;
        for (Person p : persons) {
            if (p.getId() == id) {
                index = persons.indexOf(p);
                persons.set(index, person);
            }
        }
        return index == -1
                ? new ResponseEntity<>(addPerson(person).getBody(), HttpStatus.CREATED)
                : new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable int id) {
        persons.removeIf(p -> p.getId() == id);
    }
}

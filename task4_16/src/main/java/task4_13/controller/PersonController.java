package task4_13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import task4_13.dto.Person;
import task4_13.repository.PersonRepository;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository repository;

    @GetMapping
    public Iterable<Person> getPersons() {
        return repository.findAll();
    }

    @GetMapping(params = "id")
    public Person getPerson(@RequestParam int id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        return repository.save(person);
    }

    @PutMapping("/{id}") //Способ 1
    public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable int id) {
        if(repository.existsById(id)) {
            repository.updatePersonById(id, person.getFirstname(),person.getSurname(), person.getLastname(), person.getBirthday());
            return new ResponseEntity(repository.findById(id).get(), HttpStatus.OK);
        }
        else
            return new ResponseEntity(repository.save(person), HttpStatus.CREATED);
    }

    @PutMapping(params = "id")//Способ 2
    public ResponseEntity<Person> updatePerson(@RequestParam int id, @RequestBody Person person) {
        Optional<Person> optionalPerson = repository.findById(id);
        if(optionalPerson.isPresent()) {
            Person personToUpdate = optionalPerson.get();
            personToUpdate.setFirstname(person.getFirstname() != null ? person.getFirstname() : personToUpdate.getFirstname());
            personToUpdate.setSurname(person.getSurname() != null ? person.getSurname() : personToUpdate.getSurname());
            personToUpdate.setLastname(person.getLastname() != null ? person.getLastname() : personToUpdate.getLastname());
            personToUpdate.setBirthday(person.getBirthday() != null ? person.getBirthday() : personToUpdate.getBirthday());
            return new ResponseEntity(repository.save(personToUpdate), HttpStatus.OK);
        }
            return new ResponseEntity(repository.save(person), HttpStatus.CREATED);
    }

    @DeleteMapping(params = "id")
    public void deletePerson(@RequestParam int id) {
        repository.deleteById(id);
    }
}

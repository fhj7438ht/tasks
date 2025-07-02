package task4_13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import task4_13.dto.Message;
import task4_13.dto.Person;
import task4_13.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public Iterable<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable int id) {
        return personService.getPersonById(id)
                .map(person -> new ResponseEntity<>(person, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.addPerson(person), HttpStatus.CREATED);
    }
    /* Пример
        {
          "firstname": "Иван",
          "surname": "Иванов",
          "lastname": "Иванович",
          "birthday": "2000-01-12",
          "messages": [
            {
              "title": "Cообщение",
              "text": "Пример"
            }
          ]
        }
     */

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable int id) {
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable int id) {
        personService.deletePerson(id);
    }

    @GetMapping("/{p_id}/message")
    public ResponseEntity<List<Message>> getMessagesByPerson(@PathVariable int p_id) {
        List<Message> messages = personService.getMessagesByPersonId(p_id);
        if (messages != null) {
            return new ResponseEntity<>(messages, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{p_id}/message/{m_id}")
    public ResponseEntity<Message> getMessage(@PathVariable int p_id, @PathVariable int m_id) {
        return personService.getMessageByPersonIdAndMessageId(p_id, m_id)
                .map(message -> new ResponseEntity<>(message, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping("/{p_id}/message")
    public ResponseEntity<Message> addMessage(@RequestBody Message message, @PathVariable int p_id) {
        return personService.addMessageToPerson(p_id, message);
    }

    @DeleteMapping("/{p_id}/message/{m_id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable int p_id, @PathVariable int m_id) {
        return personService.deleteMessageFromPerson(p_id, m_id);
    }
}
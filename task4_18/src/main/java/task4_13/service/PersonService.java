package task4_13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import task4_13.dto.Message;
import task4_13.dto.Person;
import task4_13.repository.MessageRepository;
import task4_13.repository.PersonRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MessageRepository messageRepository;

    public Iterable<Person> getPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(int id) {
        return personRepository.findById(id);
    }

    public Person addPerson(Person person) {
        if (person.getMessages() != null)
            person.setMessages(
                    person.getMessages().stream()
                            .peek(message -> {
                                message.setPerson(person);
                                message.setTime(LocalDateTime.now());
                            })
                            .toList()
            );
        return personRepository.save(person);
    }

    public ResponseEntity<Person> updatePerson(int id, Person person) {
        if(personRepository.existsById(id)) {
            personRepository.updatePersonById(id, person.getFirstname(), person.getSurname(), person.getLastname(), person.getBirthday());
            return new ResponseEntity<>(personRepository.findById(id).get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED);
    }

    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

    public List<Message> getMessagesByPersonId(int p_id) {
        if(personRepository.existsById(p_id)) {
            return messageRepository.findAllByPerson_IdOrderByTimeDesc(p_id);
        }
        return null;
    }

    public Optional<Message> getMessageByPersonIdAndMessageId(int p_id, int m_id) {
        Optional<Message> message = messageRepository.findById(m_id);
        if(message.isPresent() && message.get().getPerson().getId() == p_id) {
            return message;
        }
        return Optional.empty();
    }

    public ResponseEntity<Message> addMessageToPerson(int p_id, Message message) {
        Optional<Person> person = personRepository.findById(p_id);
        if(person.isPresent()) {
            message.setTime(LocalDateTime.now());
            message.setPerson(person.get());
            return new ResponseEntity<>(messageRepository.save(message), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> deleteMessageFromPerson(int p_id, int m_id) {
        Optional<Message> message = messageRepository.findById(m_id);
        if (message.isPresent() && message.get().getPerson().getId() == p_id) {
            messageRepository.delete(message.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

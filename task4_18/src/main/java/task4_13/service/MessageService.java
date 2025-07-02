package task4_13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import task4_13.dto.Message;
import task4_13.repository.MessageRepository;
import task4_13.repository.PersonRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private PersonRepository personRepository;

    public Iterable<Message> getMessages() {
        return messageRepository.findAll();
    }

    public Optional<Message> getMessageById(int id) {
        return messageRepository.findById(id);
    }

    public ResponseEntity<Message> addMessage(Message message) {
        if(personRepository.findById(message.getPerson().getId()).isPresent()) {
            message.setTime(LocalDateTime.now());
            return new ResponseEntity<>(messageRepository.save(message), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Message> updateMessage(int id, Message message) {
        if (messageRepository.existsById(id)) {
            messageRepository.updateMessageById(id, message.getTitle(), message.getText(), message.getTime());
            return new ResponseEntity<>(messageRepository.findById(id).get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(messageRepository.save(message), HttpStatus.CREATED);
    }

    public ResponseEntity<Void> deleteMessage(int id) {
        Optional<Message> message = messageRepository.findById(id);
        if (message.isPresent()) {
            messageRepository.delete(message.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
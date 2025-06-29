package task4_13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import task4_13.dto.Message;
import task4_13.repository.MessageRepository;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageRepository repository;

    @GetMapping
    public Iterable<Message> getMessages() {
        return repository.findAll();
    }

    @GetMapping(params = "id")
    public Message getMessages(@RequestParam int id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public Message addMessage(@RequestBody Message message) {
        return repository.save(message);
    }

    @PutMapping("/{id}") // Способ 1
    public ResponseEntity<Message> updateMessage(@RequestBody Message message, @PathVariable int id) {
        if (repository.existsById(id)) {
            repository.updateMessageById(id, message.getTitle(), message.getText(), message.getTime());
            return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(repository.save(message), HttpStatus.CREATED);
        }
    }

    @PutMapping(params = "id") // Способ 2
    public ResponseEntity<Message> updateMessage(@RequestParam int id, @RequestBody Message message) {
        Optional<Message> optionalMessage = repository.findById(id);
        if (optionalMessage.isPresent()) {
            Message messageToUpdate = optionalMessage.get();
            messageToUpdate.setTitle(message.getTitle() != null ? message.getTitle() : messageToUpdate.getTitle());
            messageToUpdate.setText(message.getText() != null ? message.getText() : messageToUpdate.getText());
            messageToUpdate.setTime(message.getTime() != null ? message.getTime() : messageToUpdate.getTime());
            return new ResponseEntity<>(repository.save(messageToUpdate), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(repository.save(message), HttpStatus.CREATED);
        }
    }

    @DeleteMapping(params = "id")
    public void deleteMessage(@RequestParam int id) {
        repository.deleteById(id);
    }
}

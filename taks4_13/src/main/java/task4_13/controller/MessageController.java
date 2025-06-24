package task4_13.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import task4_13.dto.Message;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/message")
public class MessageController {
    private final List<Message> messages = new ArrayList<>(Arrays.asList(
            new Message(1, "mes", "Cообщение1", LocalDateTime.now()),
            new Message(2, "mes", "Cообщение2", LocalDateTime.now())
    ));

    @GetMapping
    public List<Message> getMessages() {
        return messages;
    }

    @GetMapping("/{id}")
    public Optional<Message> getMessageById(@PathVariable int id) {
        return messages.stream().filter(m -> m.getId() == id).findFirst();
    }

    @PostMapping
    public ResponseEntity<Message> addMessage(@RequestBody Message message) {
        messages.add(message);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message) {
        int index = -1;
        for (Message m : messages) {
            if (m.getId() == id) {
                index = messages.indexOf(m);
                messages.set(index, message);
            }
        }
        return index == -1
                ? new ResponseEntity<>(addMessage(message).getBody(), HttpStatus.CREATED)
                : new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable int id) {
        messages.removeIf(m -> m.getId() == id);
    }
}

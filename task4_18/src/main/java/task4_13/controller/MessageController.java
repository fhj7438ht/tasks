package task4_13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import task4_13.dto.Message;
import task4_13.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public Iterable<Message> getMessages() {
        return messageService.getMessages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable int id) {
        return messageService.getMessageById(id)
                .map(message -> new ResponseEntity<>(message, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Message> addMessage(@RequestBody Message message) {
        return messageService.addMessage(message);
    }
    /*Пример
    {
        "title": "Cообщение",
        "text": "Пример"
        "person": {
            "id": 1
        }
    }
     */

    @PutMapping("/{id}")
    public ResponseEntity<Message> updateMessage(@RequestBody Message message, @PathVariable int id) {
        return messageService.updateMessage(id, message);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable int id) {
        return messageService.deleteMessage(id);
    }
}

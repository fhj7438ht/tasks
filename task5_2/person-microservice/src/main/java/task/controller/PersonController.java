package task.controller;

import org.springframework.web.client.RestTemplate;
import task.model.Person;
import task.model.PersonWithWeather;
import task.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public Iterable<Person> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> findById(@PathVariable int id) {
        return repository.findById(id);
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return repository.findById(person.getId())
                .map(existing -> new ResponseEntity<>(existing, HttpStatus.BAD_REQUEST))
                .orElseGet(() -> new ResponseEntity<>(repository.save(person), HttpStatus.CREATED));
    }
    @GetMapping("/{id}/with-weather")
    public ResponseEntity<PersonWithWeather> findByIdWithWeather(@PathVariable int id) {
        Optional<Person> personOpt = repository.findById(id);
        if (personOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Person person = personOpt.get();

        Object weather = restTemplate.getForObject(
                "http://weather-microservice/weather?city=" + person.getLocationName(),
                Object.class
        );

        PersonWithWeather response = new PersonWithWeather(person, weather);
        return ResponseEntity.ok(response);
    }
}
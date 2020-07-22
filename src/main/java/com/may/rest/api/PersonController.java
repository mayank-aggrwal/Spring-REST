package com.may.rest.api;

import com.may.rest.model.Person;
import com.may.rest.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;
    private static final Logger LOGGER = LogManager.getLogger(PersonController.class);

    // Spring boot injects the actual service into this constructor (Dependency Injection)
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) { // This method is to be served as a POST request
        LOGGER.info("Received POST request: Add Person: {}.", person);
        personService.addPerson(person);
        LOGGER.info("Person added to DB.");
//        Thread.sleep(10000);
    }

    @GetMapping
    public List<Person> getAllPerson() {
        LOGGER.info("Received GET request: GET All Persons.");
        List<Person> li = personService.getAllPeople();
        LOGGER.info("Found all Persons");
//        Thread.sleep(10000);
        return li;
    }

    @PutMapping(path = "{id}")
    public void updatePersonById(@PathVariable("id") UUID id, @RequestBody Person person) {
        personService.updatePerson(id, person);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }

    @GetMapping(path = "/id/{id}")
    public Person selectPersonById(@PathVariable("id") UUID id) {
        return personService.selectPersonById(id).orElse(null);
    }

    @GetMapping(path = "/health")
    public String healthCheckHandler() {
        return "Spring application is up and running";
    }

}

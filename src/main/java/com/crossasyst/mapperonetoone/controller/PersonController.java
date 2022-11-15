package com.crossasyst.mapperonetoone.controller;

import com.crossasyst.mapperonetoone.model.Person;
import com.crossasyst.mapperonetoone.model.PersonResponse;
import com.crossasyst.mapperonetoone.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Person>> getAll() {
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/persons/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> getPerson(@PathVariable Long personId) {
        Person person = personService.getPerson(personId);
        return new ResponseEntity(person, HttpStatus.OK);
    }

    @PostMapping("/persons")
    public ResponseEntity<PersonResponse> createPerson(@RequestBody Person person) {
        PersonResponse personResponse = personService.createPerson(person);
        return new ResponseEntity<>(personResponse, HttpStatus.OK);
    }

    @PutMapping(path = "person/{personId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> updatePerson(@PathVariable Long personId, @RequestBody Person person) {
        return new ResponseEntity<>(personService.updatePerson(personId, person), HttpStatus.OK);
    }

    @DeleteMapping(value = "/persons/{personId}")
    public void deleteById(@PathVariable Long personId) {
        personService.deletePerson(personId);

    }


}

package com.jaeho.javaproject.project0.mycontact.controller;

import com.jaeho.javaproject.project0.mycontact.controller.dto.PersonDto;
import com.jaeho.javaproject.project0.mycontact.domain.Person;
import com.jaeho.javaproject.project0.mycontact.repository.PersonRepository;
import com.jaeho.javaproject.project0.mycontact.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/person")
@RestController
@Slf4j
public class PersonController {
    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id) {
        return personService.getPerson(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void postPerson(@RequestBody Person person) {
        personService.put(person);
    }

    @PutMapping("/{id}")
    public void modifyPerson(@PathVariable long id, @RequestBody PersonDto personDto) {
        personService.modify(id, personDto);
    }

    @PatchMapping("/{id}")
    public void modifyPerson(@PathVariable long id, String name) {
        personService.modify(id, name);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable long id) {
        personService.delete(id);
    }
}

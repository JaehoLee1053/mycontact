package com.jaeho.javaproject.project0.mycontact.service;

import com.jaeho.javaproject.project0.mycontact.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class PersonServiceTest {
    @Autowired
    private PersonService personService;

    @Test
    void getPeopleByName() {
        List<Person> result = personService.getPeopleByName("martin");

        assertEquals(1, result.size());
        assertEquals("martin", result.get(0).getName());
    }

    @Test
    void getPerson() {
        Person person  = personService.getPerson(3L);

        assertEquals("dennis", person.getName());
    }

}
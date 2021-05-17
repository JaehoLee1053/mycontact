package com.jaeho.javaproject.project0.mycontact.repository;

import com.jaeho.javaproject.project0.mycontact.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;



    @Test
    void crud() {

        Person person = new Person();
        person.setName("martin");
        person.setAge(10);

        personRepository.save(person);

//        System.out.println(personRepository.findAll());
        List<Person> people = personRepository.findAll();

        assertEquals(1, people.size());
        assertEquals("martin", people.get(0).getName());
        assertEquals(10, people.get(0).getAge());

    }

}
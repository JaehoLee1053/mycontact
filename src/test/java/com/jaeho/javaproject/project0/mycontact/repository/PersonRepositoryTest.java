package com.jaeho.javaproject.project0.mycontact.repository;

import com.jaeho.javaproject.project0.mycontact.domain.Person;
import com.jaeho.javaproject.project0.mycontact.domain.dho.Birthday;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;



    @Test
    void crud() {

        Person person = new Person();
        person.setName("john");

        personRepository.save(person);

        List<Person> people = personRepository.findByName("john");

        assertEquals(1, people.size());
        assertEquals("john", people.get(0).getName());
//        assertEquals(10, people.get(0).getAge());

    }

    @Test
    void findByBirthdayBetween() {
        List<Person> result = personRepository.findByMonthOfBirthday(8);

        Person martin = new Person();

        assertEquals(2, result.size());
        assertEquals("martin", result.get(0).getName());
        assertEquals("sophia", result.get(1).getName());
    }

}
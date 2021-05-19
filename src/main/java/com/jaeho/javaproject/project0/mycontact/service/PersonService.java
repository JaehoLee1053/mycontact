package com.jaeho.javaproject.project0.mycontact.service;

import com.jaeho.javaproject.project0.mycontact.domain.Block;
import com.jaeho.javaproject.project0.mycontact.domain.Person;
import com.jaeho.javaproject.project0.mycontact.repository.BlockRepository;
import com.jaeho.javaproject.project0.mycontact.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockRepository blockRepository;

    public List<Person> getPeopleExcludeBlock() {
        return personRepository.findByBlockIsNull();
    }

    public List<Person> getPeopleByName(String name) {
        return personRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public Person getPerson(long id) {
//        Person person = personRepository.findById(id).get();
        Person person = personRepository.findById(id).orElse(null);


        log.info("person : {}", person);

        return person;
    }

}

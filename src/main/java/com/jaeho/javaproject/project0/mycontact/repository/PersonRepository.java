package com.jaeho.javaproject.project0.mycontact.repository;

import com.jaeho.javaproject.project0.mycontact.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // <객체, 아이디>


}

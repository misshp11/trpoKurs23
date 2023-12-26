package com.example.kursov23.services;

import com.example.kursov23.models.Person;
import com.example.kursov23.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public RegistrationService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Transactional
    public void register(Person person) {
        person.setPassword(person.getPassword());
        person.setRole("ROLE_ADMIN");
        peopleRepository.save(person);
    }
}
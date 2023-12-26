package com.example.kursov23.repositories;

import com.example.kursov23.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByUsername(String username);

    @Query("SELECT p FROM Person p WHERE p.id_group = :id")
    List<Person> findAllUserByGroup(int id);
}

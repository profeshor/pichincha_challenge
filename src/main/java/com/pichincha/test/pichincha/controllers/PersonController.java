package com.pichincha.test.pichincha.controllers;

import com.pichincha.test.pichincha.models.Person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.test.pichincha.models.PersonRepository;

@RestController
@RequestMapping("/personas")
public class PersonController {
    
    @Autowired
    private PersonRepository personRepository;

    /**
     * Obtiene todas las personas
     * @return
     */
    @GetMapping
    public List<Person> getAllPeople(){
        return personRepository.findAll();
    }

    /**
     * Obtiene una persona por su id
     * @param id id de la persona
     * @return
     */
    @GetMapping("/id")
    public Person getPersonById(@PathVariable Long id) {
        return personRepository.findById(id).get();
    }

    /**
     * Crea una persona
     * @param person
     * @return
     */
    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }
    
}

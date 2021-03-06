package com.example.controller;


import com.example.domain.*;
import com.example.repository.MovieRepository;
import com.example.repository.PersonRepository;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 */
@RestController
@RequestMapping("/person")
public class PersonController {

	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}
    @Autowired
    PersonRepository personRepository;

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/findByfirstName")
    public Person findByfirstName(@RequestParam String name) {
        return personService.findByfirstName(name);
    }

    @GetMapping("/likeName")
    public Collection<Person> findByNameLike(@RequestParam String name) {
        return personService.findByNameLike(name);
    }

    @GetMapping("/all")
    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    @GetMapping("/clean")
    public Iterable<Person> clean() {
        //clean work
        Iterable<Person> persons = personRepository.findAll();
        for (Person person : persons) {
//            person.setAMovies(null);
            personRepository.save(person);
        }
        personRepository.deleteAll();
        movieRepository.deleteAll();
        return personRepository.findAll();
    }

    @GetMapping("/init")
    public Iterable<Person> init() {
        //clean work
        Iterable<Person> persons = personRepository.findAll();
        for (Person person : persons) {
//            person.setAMovies(null);
            personRepository.save(person);
        }
        personRepository.deleteAll();
        movieRepository.deleteAll();

        //????????????????????????
        //????????? ???????????????A???
        Person clPerson  = new Person("ChengLongP", "Jack", 175);
        //??????????????????B???
        Person jtPerson = new Person("JingTianP", "JT", 170);
        //??????????????????B??? ???????????????A???
        Person ldhPerson = new Person("LiuDeHuaP", "DeHua", 180);
        //??????????????????B???
        Person zymPerson  = new Person("ZhangYiMouP", "YiMou", 176);

        personRepository.save(clPerson);
        personRepository.save(jtPerson);
        personRepository.save(ldhPerson);
        personRepository.save(zymPerson);

        Movie jgMovie = new Movie("????????????A" , "history", 9000);
        movieRepository.save(jgMovie);
        Movie clMovie = new Movie("??????B", "science fiction", 5000);
        movieRepository.save(clMovie);

        clPerson.addActMovie(jgMovie);

        jtPerson.addActMovie(clMovie);

        ldhPerson.addActMovie(jgMovie);
        ldhPerson.addActMovie(clMovie);

        zymPerson.addDirectMovie(clMovie);

        personRepository.save(clPerson);
        personRepository.save(jtPerson);
        personRepository.save(ldhPerson);
        personRepository.save(zymPerson);

        return personRepository.findAll();
    }


    @GetMapping("/test")
    public Iterable<Person> personTest() {

        Movie jgMovie = new Movie("????????????A" , "history", 9000);
        movieRepository.save(jgMovie);
        Movie clMovie = new Movie("??????B", "science fiction", 5000);
        movieRepository.save(clMovie);

        Person clPerson  = new Person("ChengLongP", "Jack", 175);
        //??????????????????B???
        Person jtPerson = new Person("JingTianP", "JT", 170);
        //??????????????????B??? ???????????????A???
        Person ldhPerson = new Person("LiuDeHuaP", "DeHua", 180);
        //??????????????????B???
        Person zymPerson  = new Person("ZhangYiMouP", "YiMou", 176);

        clPerson.addActMovie(jgMovie);

        jtPerson.addActMovie(clMovie);

        ldhPerson.addActMovie(jgMovie);
        ldhPerson.addActMovie(clMovie);

        zymPerson.addDirectMovie(clMovie);

        personRepository.save(clPerson);
        personRepository.save(jtPerson);
        personRepository.save(ldhPerson);
        personRepository.save(zymPerson);

        return personRepository.findAll();
    }

}

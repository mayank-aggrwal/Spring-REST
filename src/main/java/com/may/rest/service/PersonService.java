package com.may.rest.service;

import com.may.rest.dao.PersonDao;
import com.may.rest.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;
    private static final Logger LOGGER = LogManager.getLogger(PersonService.class);

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        LOGGER.info("Adding Person: {}.", person);
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        LOGGER.info("Getting all Persons");
        return personDao.selectAllPeople();
    }

    public int updatePerson(UUID id, Person person) {
        return personDao.updatePerson(id, person);
    }

    public int deletePerson(UUID id) {
        return personDao.deletePerson(id);
    }

    public Optional<Person> selectPersonById(UUID id) {
        return personDao.selectPersonById(id);
    }

}

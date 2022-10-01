package com.may.rest.dao;

import com.may.rest.model.Person;
import com.may.rest.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.Map;

// This class is to be instantiated as a bean (class is to be served as a repository)
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();
    private static final Logger LOGGER = LogManager.getLogger(FakePersonDataAccessService.class);
    
    @Override
    public int insertPerson(UUID id, Person person) {
        LOGGER.info("Inserting into DB, person with id: {}, name: {}", id, person.getName());
        DB.add(new Person(id, person.getName()));
        return 0;
    }
    
    @Override
    public List<Person> selectAllPeople() {
        LOGGER.info("Getting all people.");
        return DB;
    }

}

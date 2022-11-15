package com.crossasyst.mapperonetoone.service;

import com.crossasyst.mapperonetoone.entity.PersonEntity;
import com.crossasyst.mapperonetoone.mapper.PersonMapper;
import com.crossasyst.mapperonetoone.model.Person;
import com.crossasyst.mapperonetoone.model.PersonResponse;
import com.crossasyst.mapperonetoone.repository.AddressRepository;
import com.crossasyst.mapperonetoone.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    private final AddressRepository addressRepository;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
        this.addressRepository = addressRepository;
    }

    public PersonResponse createPerson(Person person) {
        PersonEntity personEntity = personMapper.modelToEntity(person);
        personRepository.save(personEntity);
        PersonResponse personResponse = new PersonResponse();
        personResponse.setPersonId(personEntity.getPersonId());
        return personResponse;
    }

    public List<Person> getAll() {
        List<PersonEntity> personEntities = personRepository.findAll();
        List<Person> person = personMapper.entityToModels(personEntities);

        return person;
    }

    public Person getPerson(Long personId) {
;
        PersonEntity personEntity = personRepository.getOne(personId);
        Person person = personMapper.entityToModel(personEntity);
        return person;
    }

    public Person updatePerson(Long personId, Person person) {
        PersonEntity personEntity1 = personRepository.findById(personId).get();
        PersonEntity personEntity = personMapper.modelToEntity(person);
        personEntity.getAddress().setAddressId(personEntity1.getAddress().getAddressId());
        personEntity.setPersonId(personId);
        personRepository.save(personEntity);
        return person;
    }

    public void deletePerson(Long personId) {
        Optional<PersonEntity> personEntity = personRepository.findById(personId);

        if (personEntity.isPresent()) {
            personRepository.deleteById(personId);
        } else {

            log.info("PersonId " + personId + " Not Present");
        }

    }
}
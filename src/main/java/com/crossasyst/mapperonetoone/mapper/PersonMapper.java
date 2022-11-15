package com.crossasyst.mapperonetoone.mapper;

import com.crossasyst.mapperonetoone.entity.PersonEntity;
import com.crossasyst.mapperonetoone.model.Person;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    public  PersonEntity modelToEntity(Person person);

    public Person entityToModel(PersonEntity personEntity);

    public List<Person> entityToModels(List<PersonEntity> personEntities);
}

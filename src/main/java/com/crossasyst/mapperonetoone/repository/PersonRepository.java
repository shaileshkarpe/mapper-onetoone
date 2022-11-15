package com.crossasyst.mapperonetoone.repository;

import com.crossasyst.mapperonetoone.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Long> {
}

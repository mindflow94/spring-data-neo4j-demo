package com.example.repository;

import java.util.Collection;
import java.util.List;

import com.example.domain.*;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created on 2022/3/9.
 *
 * @author MariaCarrie
 */
@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {

	Person findByfirstName(@Param("firstName") String firstName);

	Collection<Person> findByfirstNameLike(@Param("firstName") String firstName);
}
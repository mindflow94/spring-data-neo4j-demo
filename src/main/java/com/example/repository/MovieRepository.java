package com.example.repository;

import com.example.domain.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created on 2022/3/9.
 *
 * @author MariaCarrie
 */
@Repository
public interface MovieRepository extends Neo4jRepository<Movie, Long> {

    Movie findByTitle(@Param("title") String title);

    Collection<Movie> findByRevenueGreaterThan(int revenue);

}
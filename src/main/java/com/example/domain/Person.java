package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 */
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@NodeEntity
public class Person{
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private int height;

    public Person (String firstName, String lastName, int height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
    }
    @JsonIgnoreProperties("models")
    @Relationship(type = "ACTED_IN", direction = Relationship.OUTGOING)
    private List<Movie> aMovies;

    //也就是演员指向电影
    @Relationship(type = "DIRECTED", direction = Relationship.OUTGOING)
    private List<Movie> dMovies;

    //Entities handled by the OGM must have one empty public constructor to allow the library to construct the objects.
    public void addActMovie(Movie movie) {
        if (this.aMovies == null) {
            this.aMovies = new ArrayList<>();
        }
        this.aMovies.add(movie);
    }

    public void addDirectMovie(Movie movie) {
        if (this.dMovies == null) {
            this.dMovies = new ArrayList<>();
        }
        this.dMovies.add(movie);
    }
}

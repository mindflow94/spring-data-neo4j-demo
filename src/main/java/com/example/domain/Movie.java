package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 *
 */
@NodeEntity
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Data
public class Movie{
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String category;
    private int revenue;

    public Movie(String title, String category, int revenue) {
        this.title = title;
        this.category = category;
        this.revenue = revenue;
    }
}

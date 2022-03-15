package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.springframework.data.neo4j.annotation.QueryResult;

/**
 */
@QueryResult
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class TableSimple {
    @Id
    @GeneratedValue
    private Long id;
    private String fullTable;
    private String temporary;
}

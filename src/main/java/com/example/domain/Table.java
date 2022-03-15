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
public class Table {
    @Id
    @GeneratedValue
    private Long id;
    private String fullTable;
    private String temporary;
    private String category;
    private String createTime;
    private String dbName;
    private String tableName;
}

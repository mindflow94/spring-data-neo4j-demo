package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 */
@Data
@NodeEntity(label = "COLUMN")
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class FiledHeatColumn {
    @Id
    @GeneratedValue
    private Long id;
    private String fullTable;
    private String temporary;
    private String field;
    private String createTime;
    private String fullField;
}

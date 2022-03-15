package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

/**
 * Created on 2022/3/8.
 *
 * @author MariaCarrie
 */
@RelationshipEntity(type = "generate")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Data
public class FiledHeatAll {
    @Id
    private Long id;
    private String expression;
    private String createTime;
    private String edgeType;
    private String start;
    private String end;
    private String endTemporary;
    private String startTemporary;
    @StartNode
    private FiledHeatColumn startNode;

    @EndNode
    private FiledHeatColumn endNode;
}

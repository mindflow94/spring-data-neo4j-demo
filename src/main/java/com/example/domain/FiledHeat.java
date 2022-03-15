package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.annotation.QueryResult;

/**
 * Created on 2022/3/8.
 *
 * @author MariaCarrie
 */
@QueryResult
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Data
public class FiledHeat {
    private String fullField;
    private String expression;
    private String createTime;
    private String edgeType;
    private String start;
    private String end;
    private String endTemporary;
    private String startTemporary;
}

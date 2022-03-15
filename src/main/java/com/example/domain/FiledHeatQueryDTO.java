package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.neo4j.annotation.QueryResult;

/**
 * Created on 2022/3/8.
 * 查看neo4j的自定义实体类
 *
 * @author MariaCarrie
 */
@Data
@Accessors(chain = true)
@QueryResult
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class FiledHeatQueryDTO {
    private String fullField;
    private String expression;
    private String createTime;
    private String edgeType;
    private String start;
    private String end;
    private String endTemporary;
    private String startTemporary;
}

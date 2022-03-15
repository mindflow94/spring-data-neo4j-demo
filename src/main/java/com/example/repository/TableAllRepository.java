package com.example.repository;

import com.example.domain.*;
import org.springframework.data.neo4j.annotation.Query;
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
public interface TableAllRepository extends Neo4jRepository<FiledHeatAll, Long> {

    /**
     * 1. 设置节点的lable
     * 2. 设置关系的type
     * 3. Boolean 转string存在问题，需要再看看
     * 4. @RelationshipEntity(type = "generate") 在项目中只能定义一个
     * @return
     */
    @Query(value = "match filedHeatAll =(c:COLUMN)-[r:generate]->(d:COLUMN) return filedHeatAll")
    Collection<FiledHeatAll> fieldAll();

    /**
     * 需要通过 @Param注解表明参数名称，否则会报错，找不到params
     * @param fullTableName
     * @return
     */
    @Query(value = "match filedHeatAll =((n:COLUMN{fullTable:{fullTableName}})-[rel:generate]->(m)) where m.temporary=false return filedHeatAll")
//    @Query(value = "match filedHeatAll =(c:COLUMN)-[r:generate]->(d:COLUMN) where c.fullTable={fullTableName} return filedHeatAll")
    Collection<FiledHeatAll> fieldAllByName(@Param("fullTableName")String fullTableName);


    /**
     * :#{#对象名.属性}
     * @param tableParam
     * @return
     */
    @Query(value = "match filedHeatAll =(c:COLUMN)-[r:generate]->(d:COLUMN) where c.fullTable= :#{#tableParam.tableName} return filedHeatAll")
    Collection<FiledHeatAll> fieldAllByObject(@Param("tableParam") TableParam tableParam);

    @Query("call apoc.cypher.run({cql}, null) yield value return value.p")
    Collection<FiledHeatAll> findByCql(@Param("cql") String cql);

}